package io.pokemontcg;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
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
        HttpUrl.Builder urlBuilder = HttpUrl.parse(pokemonTcgIoUrl + endpointName).newBuilder();
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response;

        if (id != null && !id.isEmpty()) {
            urlBuilder.addPathSegment(id);
        } else if (parameters != null && !parameters.isEmpty()) {
            parameters.forEach(urlBuilder::addQueryParameter);
        }

        String url = urlBuilder.build().toString();
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
}
