package io.pokemontcg;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.pokemontcg.model.AbstractModel;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
abstract class AbstractBuilder {

    private final static Logger LOGGER = Logger.getLogger(AbstractBuilder.class.getName());

    private HashMap<String, String> queryParameters = new HashMap<>();

    protected abstract String getEndpointName();
    protected abstract Class getMappingClass();

    protected HashMap<String, String> getQueryParameters() {
        return this.queryParameters;
    }

    protected <T extends AbstractModel> T findAll() throws IOException {
        Response response = QueryHelper.runQuery(getEndpointName(), queryParameters);
        queryParameters.clear();
        return mapJsonResponseToClass(getMappingClass(), response);
    }

    protected <T extends AbstractModel> T findById(String id) throws IOException {
        queryParameters.clear();
        Response response = QueryHelper.runQuery(getEndpointName(), id);
        return mapJsonResponseToClass(getMappingClass(), response);
    }

    private <T extends AbstractModel> T mapJsonResponseToClass(Type type, Response response) throws IOException {
        if (response != null) {
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<T> jsonAdapter = moshi.adapter(type);
            
            try {
                String responseBody = response.body().string();
                LOGGER.log(Level.INFO, "Mapping response: " + responseBody);
                T model = jsonAdapter.fromJson(responseBody);
                if (model != null) {
                    Headers headers = response.headers();
                    model.setCount((headers.get("count") != null && !headers.get("count").isEmpty()) ? Integer.parseInt(headers.get("count")) : 0);
                    model.setTotalCount((headers.get("total-count") != null && !headers.get("total-count").isEmpty()) ? Integer.parseInt(headers.get("total-count")) : 0);
                    model.setLinks(headers.get("link"));
                    model.setPageSize((headers.get("page-size") != null && !headers.get("page-size").isEmpty()) ? Integer.parseInt(headers.get("page-size")) : 0);
                    model.setRateLimit(headers.get("ratelimit-limit"));
                    model.setRateLimitRemaining(headers.get("ratelimit-remaining"));
                }
                return model;
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage());
                throw ex;
            } finally {
                response.close();
            }
        }
        return null;
    }
}
