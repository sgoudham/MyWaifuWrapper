package org.goudham.me;

import org.goudham.me.api.entity.series.FilteredSeries;
import org.goudham.me.api.entity.series.Series;
import org.goudham.me.api.entity.waifu.Waifu;
import org.goudham.me.exception.APIMapperException;
import org.goudham.me.exception.APIResponseException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * Returns API information to {@link MyWaifuClient}
 */
public class APIWrapper {
    private final String version = "1.0";
    private static final String host = "https://mywaifulist.moe/api/v1/";
    private final String apiKey;

    private final APIMapper apiMapper;

    /**
     * Instantiates an instance of {@link APIWrapper} to retrieve API Information.
     * An instance of {@link APIMapper} is created to be able to {@link APIMapper#deserialize(Result, Class)} JSON to
     * Java objects
     *
     * @param apiKey API Key to authorise API request
     *
     */
    APIWrapper(String apiKey) {
        this.apiKey = apiKey;
        apiMapper = new APIMapper();
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

    Response<Waifu> getWaifu(HttpClient httpClient, String param) throws APIResponseException, APIMapperException {
        Result waifuResult = sendRequest(httpClient, "waifu/" + param);
        return apiMapper.deserialize(waifuResult, Waifu.class);
    }

    Response<Series> getSeries(HttpClient httpClient, String param) throws APIResponseException, APIMapperException {
        Result seriesResult = sendRequest(httpClient, "series/" + param);
        return apiMapper.deserialize(seriesResult, Series.class);
    }

    Response<List<FilteredSeries>> getAiringAnime(HttpClient httpClient) throws APIResponseException, APIMapperException {
        Result seriesResult = sendRequest(httpClient, "airing");
        return apiMapper.deserializeToList(seriesResult, FilteredSeries.class);
    }
}
