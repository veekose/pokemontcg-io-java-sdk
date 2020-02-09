package io.pokemontcg;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class QueryHelper {

    private final static Logger LOGGER = Logger.getLogger(QueryHelper.class.getName());

    private static final String pokemonTcgIoUrl = "https://api.pokemontcg.io/v1/";

    public static Response runQuery(String endpointName, String id) throws IOException {
        return runQuery(endpointName, null, id);
    }

    public static Response runQuery(String endpointName, HashMap<String, String> parameters) throws IOException {
        return runQuery(endpointName, parameters, null);
    }

    private static Response runQuery(String endpointName, HashMap<String, String> parameters, String id) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = pokemonTcgIoUrl + endpointName + "/";
        String queryString = "";
        String responseBody = null;
        Response response = null;

        if (id != null && !id.isEmpty()) {
            queryString = id;
        } else if (parameters != null && !parameters.isEmpty()) {
            queryString = buildQueryString(parameters);
        }

        url += queryString;
        Request request = new Request.Builder().url(url).build();

        try {
            LOGGER.log(Level.INFO, "Requesting URL: " + url);
            response = okHttpClient.newCall(request).execute();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            throw ex;
        }

        return response;
    }

    private static String buildQueryString(HashMap<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        String delimiter = "";

        sb.append("?");
        for (Map.Entry<String, String> e : parameters.entrySet()) {
            sb.append(delimiter);

            if (e.getValue() != null && !e.getValue().isEmpty()) {
                if (e.getKey() != null && !e.getKey().isEmpty()) {
                    sb.append(e.getKey()).append("=");
                }
                sb.append(e.getValue());

                if (delimiter.isEmpty()) {
                    delimiter = "&";
                }
            }
        }

        return sb.toString();
    }
}
