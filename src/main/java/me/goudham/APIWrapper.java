package me.goudham;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import me.goudham.util.Season;
import me.goudham.api.entity.series.FilteredSeries;
import me.goudham.api.entity.series.Series;
import me.goudham.api.entity.user.User;
import me.goudham.api.entity.waifu.FilteredWaifu;
import me.goudham.api.entity.waifu.Waifu;
import me.goudham.exception.APIMapperException;
import me.goudham.exception.APIResponseException;

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
 *
 */
public class APIWrapper {
    private final String version = "1.0";
    private static final String host = "https://mywaifulist.moe/api/v1/";
    private final String apiKey;

    private final APIMapper apiMapper;
    private final HttpClient httpClient;

    /**
     * Instantiates an instance of {@link APIWrapper} to retrieve API Information.
     * An instance of {@link APIMapper} is created to be able to {@link APIMapper#deserialize(Result, Class)} JSON to
     * Java objects
     *
     * @param apiKey API Key to authorise API request
     * @param httpClient The underlying {@link HttpClient} to use for HttpRequests
     *
     */
    APIWrapper(String apiKey, HttpClient httpClient) {
        this.apiKey = apiKey;
        this.httpClient = httpClient;
        apiMapper = new APIMapper();
    }

    /**
     * Honestly I don't really know how this works
     *
     * @param entity The actual class of the given entity. E.g {@link Waifu#getClass()}
     * @param <T> The type of entity to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link JavaType}
     *
     */
    private <T> JavaType listOf(Class<T> entity) {
        return TypeFactory.defaultInstance().constructCollectionType(List.class, entity);
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

    Response<Waifu> getWaifu(String param) throws APIResponseException, APIMapperException {
        Result waifuResult = sendRequest(httpClient, "waifu/" + param);
        return apiMapper.deserialize(waifuResult, Waifu.class);
    }

    Response<FilteredWaifu> getDailyWaifu() throws APIResponseException, APIMapperException {
        Result dailyWaifuResult = sendRequest(httpClient, "meta/daily");
        return apiMapper.deserialize(dailyWaifuResult, FilteredWaifu.class);
    }

    Response<FilteredWaifu> getRandomWaifu() throws APIResponseException, APIMapperException {
        Result randomWaifuResult = sendRequest(httpClient, "meta/random");
        return apiMapper.deserialize(randomWaifuResult, FilteredWaifu.class);
    }

    Response<Series> getSeries(String param) throws APIResponseException, APIMapperException {
        Result seriesResult = sendRequest(httpClient, "series/" + param);
        return apiMapper.deserialize(seriesResult, Series.class);
    }

    Response<List<FilteredSeries>> getSeasonalAnime() throws APIResponseException, APIMapperException {
        Result seasonalAnimeResult = sendRequest(httpClient, "airing");
        return apiMapper.deserialize(seasonalAnimeResult, listOf(FilteredSeries.class));
    }

    Response<List<FilteredWaifu>> getBestWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendRequest(httpClient, "airing/best");
        return apiMapper.deserialize(waifuResults, listOf(FilteredWaifu.class));
    }

    Response<List<FilteredWaifu>> getPopularWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendRequest(httpClient, "airing/popular");
        return apiMapper.deserialize(waifuResults, listOf(FilteredWaifu.class));
    }

    Response<List<FilteredWaifu>> getTrashWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendRequest(httpClient, "airing/trash");
        return apiMapper.deserialize(waifuResults, listOf(FilteredWaifu.class));
    }

    Response<List<FilteredSeries>> getAllSeries(Season season, Integer year) throws APIResponseException, APIMapperException {
        Result allSeriesResult = sendRequest(httpClient, "airing/" + season.getSeason() + "/" + year);
        return apiMapper.deserialize(allSeriesResult, listOf(FilteredSeries.class));
    }

    Response<List<FilteredWaifu>> getSeriesWaifus(String param) throws APIResponseException, APIMapperException {
        Result allWaifusFromSeriesResults = sendRequest(httpClient, "series/" + param + "/waifus");
        return apiMapper.deserialize(allWaifusFromSeriesResults, listOf(FilteredWaifu.class));
    }

    Response<User> getUserProfile(String param) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendRequest(httpClient, "user/" + param);
        return apiMapper.deserialize(userProfileResult, User.class);
    }
}
