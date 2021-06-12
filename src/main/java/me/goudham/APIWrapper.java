package me.goudham;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import me.goudham.domain.pagination.PaginationData;
import me.goudham.domain.series.FilteredSeries;
import me.goudham.domain.series.Series;
import me.goudham.domain.user.User;
import me.goudham.domain.user.UserList;
import me.goudham.domain.waifu.FilteredWaifu;
import me.goudham.domain.waifu.Waifu;
import me.goudham.domain.waifu.WaifuImage;
import me.goudham.exception.APIMapperException;
import me.goudham.exception.APIResponseException;
import me.goudham.util.Season;

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
     * @param model The actual class of the given model. E.g {@link Waifu#getClass()}
     * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link JavaType}
     *
     */
    private <T> JavaType listOf(Class<T> model) {
        return TypeFactory.defaultInstance().constructCollectionType(List.class, model);
    }

    private <T> JavaType paginationData(Class<T> model) {
        return TypeFactory.defaultInstance().constructParametricType(PaginationData.class, model);
    }

    /**
     * Handles sending a request to the API asynchronously using {@link HttpRequest}
     * and the underlying {@link HttpClient}
     *
     * @param param The end of the endpoint appended onto the host
     * @return {@link Result}
     * @throws APIResponseException If the {@link CompletableFuture Response}
     * cannot be decoded or the thread was interrupted while waiting to receive the data
     *
     */
    private Result sendRequest(String param) throws APIResponseException {
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

    Response<Waifu> getWaifu(String waifuId) throws APIResponseException, APIMapperException {
        Result waifuResult = sendRequest("waifu/" + waifuId);
        return apiMapper.deserialize(waifuResult, Waifu.class);
    }

    Response<PaginationData<WaifuImage>> getWaifuImages(String waifuId, String pageNum) throws APIResponseException, APIMapperException {
        Result waifuImagesResult = sendRequest("waifu/" + waifuId + "/images?page=" + pageNum);
        return apiMapper.deserializeToPaginationData(waifuImagesResult, paginationData(WaifuImage.class));
    }

    Response<FilteredWaifu> getDailyWaifu() throws APIResponseException, APIMapperException {
        Result dailyWaifuResult = sendRequest("meta/daily");
        return apiMapper.deserialize(dailyWaifuResult, FilteredWaifu.class);
    }

    Response<FilteredWaifu> getRandomWaifu() throws APIResponseException, APIMapperException {
        Result randomWaifuResult = sendRequest("meta/random");
        return apiMapper.deserialize(randomWaifuResult, FilteredWaifu.class);
    }

    Response<Series> getSeries(String seriesId) throws APIResponseException, APIMapperException {
        Result seriesResult = sendRequest("series/" + seriesId);
        return apiMapper.deserialize(seriesResult, Series.class);
    }

    Response<List<FilteredSeries>> getSeasonalAnime() throws APIResponseException, APIMapperException {
        Result seasonalAnimeResult = sendRequest("airing");
        return apiMapper.deserializeToList(seasonalAnimeResult, listOf(FilteredSeries.class));
    }

    Response<List<FilteredWaifu>> getBestWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendRequest("airing/best");
        return apiMapper.deserializeToList(waifuResults, listOf(FilteredWaifu.class));
    }

    Response<List<FilteredWaifu>> getPopularWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendRequest("airing/popular");
        return apiMapper.deserializeToList(waifuResults, listOf(FilteredWaifu.class));
    }

    Response<List<FilteredWaifu>> getTrashWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendRequest("airing/trash");
        return apiMapper.deserializeToList(waifuResults, listOf(FilteredWaifu.class));
    }

    Response<List<FilteredSeries>> getAllSeries(Season season, Integer year) throws APIResponseException, APIMapperException {
        Result allSeriesResult = sendRequest("airing/" + season.getSeason() + "/" + year);
        return apiMapper.deserializeToList(allSeriesResult, listOf(FilteredSeries.class));
    }

    Response<List<FilteredWaifu>> getSeriesWaifus(String seriesId) throws APIResponseException, APIMapperException {
        Result allWaifusFromSeriesResults = sendRequest("series/" + seriesId + "/waifus");
        return apiMapper.deserializeToList(allWaifusFromSeriesResults, listOf(FilteredWaifu.class));
    }

    Response<User> getUserProfile(String userId) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendRequest("user/" + userId);
        return apiMapper.deserialize(userProfileResult, User.class);
    }

    Response<List<UserList>> getUserLists(String userId) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendRequest("user/" + userId + "/lists");
        return apiMapper.deserializeToList(userProfileResult, listOf(UserList.class));
    }

    Response<UserList> getUserList(String userId, String listId) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendRequest("user/" + userId + "/lists/" + listId);
        return apiMapper.deserialize(userProfileResult, UserList.class);
    }
}
