package org.goudham.me;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.goudham.me.api.entity.series.Series;
import org.goudham.me.api.entity.waifu.Waifu;
import org.goudham.me.exception.APIMapperException;
import org.goudham.me.exception.APIResponseException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * Returns API information to {@link MyWaifuClient}
 */
public class MyWaifuWrapper {
    private final String version = "1.0";
    private static final String host = "https://mywaifulist.moe/api/v1/";
    private final String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Instantiates an instance of {@link MyWaifuWrapper} to retrieve API Information
     * @param apiKey API Key to authorise API request
     */
    MyWaifuWrapper(String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Handles sending a request to the API asynchronously using {@link HttpRequest}
     * and the underlying {@link HttpClient}
     *
     * @param httpClient The {@link HttpClient} to use for sending {@link HttpRequest}'s
     * @param param The end of the endpoint appended onto the host
     * @return {@link Result}
     * @throws APIResponseException If the {@link CompletableFuture Response}
     * cannot be decoded or the thread was interrupted while waiting to receive the data
     *
     */
    private Result sendRequest(HttpClient httpClient, String param) throws APIResponseException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + param))
                .version(httpClient.version())
                .timeout(Duration.ofSeconds(20))
                .headers("Content-Type", "application/json", "apikey", apiKey)
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        int responseCode;
        String responseBody;
        try {
            responseCode = response.thenApply(HttpResponse::statusCode).get();
            responseBody = response.thenApply(HttpResponse::body).get();
        } catch (InterruptedException | ExecutionException exp) {
            throw new APIResponseException(exp.getMessage(), exp);
        }

        return new Result(responseCode, responseBody);
    }

    private <T> Response<T> getPopulatedResponse(Result result, Class<T> entity) throws APIMapperException {
        Integer statusCode = result.getStatusCode();
        String body = result.getBody();
        T newEntity = null;

        if (statusCode == 200) {
            try {
                JsonNode parent = objectMapper.readTree(body);
                String data = parent.get("data").toString();
                newEntity = objectMapper.readValue(data, entity);
            } catch (JsonProcessingException jpe) {
                String customExceptionMessage = "If you are seeing this message, this is more than likely a fault in my logic. " +
                        "Please raise an issue including the printed stacktrace :D";
                String exceptionMessage = "\n\n" + customExceptionMessage + "\n\n" + jpe.getMessage();

                throw new APIMapperException(exceptionMessage, jpe);
            }
        }

        return new Response<>(statusCode, body, newEntity);
    }

    Response<Waifu> getWaifu(HttpClient httpClient, String param) throws APIResponseException, APIMapperException {
        Result waifuResult = sendRequest(httpClient, "waifu/" + param);
        return getPopulatedResponse(waifuResult, Waifu.class);
    }

    Response<Series> getSeries(HttpClient httpClient, String param) throws APIResponseException, APIMapperException {
        Result seriesResult = sendRequest(httpClient, "series/" + param);
        return getPopulatedResponse(seriesResult, Series.class);
    }
}
