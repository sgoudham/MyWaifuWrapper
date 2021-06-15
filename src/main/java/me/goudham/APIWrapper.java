package me.goudham;

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
import me.goudham.util.WaifuListType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static me.goudham.APIUtils.listOf;
import static me.goudham.APIUtils.paginationData;


/**
 * Returns API information to {@link MyWaifuClient}
 *
 */
public class APIWrapper {
    private final String version = "1.0";
    private static final String host = "https://mywaifulist.moe/api/v1/";
    private String apiKey;

    private final APIMapper apiMapper;
    private final HttpClient httpClient;
    private final Executor executor = Executors.newFixedThreadPool(10);

    /**
     * Instantiates an instance of {@link APIWrapper} to retrieve API Information.
     * An instance of {@link APIMapper} is created to be able to {@code deserialize} JSON to
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
     * Create base {@link HttpRequest.Builder} with custom url, default headers and timeout
     *
     * @param param The end of the endpoint appended onto the host
     * @return {@link HttpRequest.Builder}
     *
     */
    private HttpRequest.Builder getBaseRequest(String param) {
        return HttpRequest.newBuilder()
                .uri(URI.create(host + param))
                .timeout(Duration.ofSeconds(20))
                .headers("Content-Type", "application/json", "apikey", apiKey);
    }

    /**
     * Separate method for sending GET requests
     *
     * @param param The end of the endpoint appended onto the host
     * @return {@link Result}
     * @throws APIResponseException If {@link #sendRequest(HttpRequest)} cannot retrieve the proper data from the API
     *
     */
    Result sendGetRequest(String param) throws APIResponseException {
        HttpRequest request = getBaseRequest(param).GET().build();
        return sendRequest(request);
    }

    /**
     * Separate method for sending POST requests
     *
     * @param param The end of the endpoint appended onto the host
     * @param headers Headers as Key/Value pairs for POST requests
     * @return {@link Result}
     * @throws APIResponseException If {@link #sendRequest(HttpRequest)} cannot retrieve the proper data from the API
     * @throws APIMapperException If {@link APIMapper#getObjectAsString(Object)} cannot properly serialize object
     *
     */
    private Result sendPostRequest(String param, Map<String, String> headers) throws APIResponseException, APIMapperException {
        HttpRequest request = getBaseRequest(param)
                .POST(HttpRequest.BodyPublishers.ofString(apiMapper.getObjectAsString(headers)))
                .build();
        return sendRequest(request);
    }

    /**
     * Handles sending a request to the API asynchronously using {@link HttpRequest}
     * and the underlying {@link HttpClient}
     *
     * @param httpRequest The {@link HttpRequest} to be sent by the {@link HttpClient}
     * @return {@link Result}
     * @throws APIResponseException If the {@link CompletableFuture Response}
     * cannot be decoded or the thread was interrupted while waiting to receive the data
     *
     */
    private Result sendRequest(HttpRequest httpRequest) throws APIResponseException {
        CompletableFuture<Result> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException exp) {
                exp.printStackTrace();
            }
            return null;
        }, executor).thenApply(httpResponse -> new Result(httpResponse.statusCode(), httpResponse.body()));

        try {
            return futureResult.get();
        } catch (InterruptedException | ExecutionException exp) {
            throw new APIResponseException(exp.getMessage(), exp);
        }
    }

    /**
     * Retrieve detailed information about the {@link Waifu} by sending request to API
     *
     * @param waifuId The id of the {@link Waifu}
     * @return {@link Response} of {@link Waifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<Waifu> getWaifu(String waifuId) throws APIResponseException, APIMapperException {
        Result waifuResult = sendGetRequest("waifu/" + waifuId);
        return apiMapper.deserialize(waifuResult, Waifu.class);
    }

    /**
     * Retrieve paginated images from the gallery, in sets of 10, by sending request to API
     *
     * @param waifuId The id of the {@link Waifu}
     * @param pageNum The page number of the gallery
     * @return {@link Response} of {@link WaifuImage}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<PaginationData<WaifuImage>> getWaifuImages(String waifuId, String pageNum) throws APIResponseException, APIMapperException {
        Result waifuImagesResult = sendGetRequest("waifu/" + waifuId + "/images?page=" + pageNum);
        return apiMapper.deserializeToPaginationData(waifuImagesResult, paginationData(WaifuImage.class));
    }

    /**
     * Retrieve an array of {@link FilteredWaifu}'s, sorted alphabetically, by sending request to API
     *
     * @param pageNum The page number of the gallery
     * @return {@link Response} of {@link PaginationData} with {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<PaginationData<FilteredWaifu>> getWaifusByPage(String pageNum) throws APIResponseException, APIMapperException {
        Result waifusByPageResult = sendGetRequest("waifu?page=" + pageNum);
        return apiMapper.deserializeToPaginationData(waifusByPageResult, paginationData(FilteredWaifu.class));
    }

    /**
     * Retrieve the Waifu of the Day by sending request to API
     *
     * @return {@link Response} of {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<FilteredWaifu> getDailyWaifu() throws APIResponseException, APIMapperException {
        Result dailyWaifuResult = sendGetRequest("meta/daily");
        return apiMapper.deserialize(dailyWaifuResult, FilteredWaifu.class);
    }

    /**
     * Retrieve a Random Waifu from the Website by sending request to API
     *
     * @return {@link Response} of {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<FilteredWaifu> getRandomWaifu() throws APIResponseException, APIMapperException {
        Result randomWaifuResult = sendGetRequest("meta/random");
        return apiMapper.deserialize(randomWaifuResult, FilteredWaifu.class);
    }

    /**
     * Retrieve a List of Currently Airing Anim by sending request to API
     *
     * @return {@link Response} of {@link List} with {@link FilteredSeries}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredSeries>> getSeasonalAnime() throws APIResponseException, APIMapperException {
        Result seasonalAnimeResult = sendGetRequest("airing");
        return apiMapper.deserializeToList(seasonalAnimeResult, listOf(FilteredSeries.class));
    }

    /**
     * Retrieve the Best Waifus of the Current Season by sending request to API
     *
     * @return {@link Response} of {@link List} with {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredWaifu>> getBestWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendGetRequest("airing/best");
        return apiMapper.deserializeToList(waifuResults, listOf(FilteredWaifu.class));
    }

    /**
     * Retrieve a List of Popular Waifus <i>(Raw Count of Total Votes)</i> of the Current Season
     * by sending request to API
     *
     * @return {@link Response} of {@link List} with {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredWaifu>> getPopularWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendGetRequest("airing/popular");
        return apiMapper.deserializeToList(waifuResults, listOf(FilteredWaifu.class));
    }

    /**
     * Retrieve the Most Disliked Waifus of the Current Season by sending request to API
     *
     * @return {@link Response} of {@link List} with {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredWaifu>> getTrashWaifus() throws APIResponseException, APIMapperException {
        Result waifuResults = sendGetRequest("airing/trash");
        return apiMapper.deserializeToList(waifuResults, listOf(FilteredWaifu.class));
    }

    /**
     * Retrieve detailed information about a given {@link Series} by sending request to API
     *
     * @param seriesId The id of the {@link Series}
     * @return {@link Response} of {@link Series}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<Series> getSeries(String seriesId) throws APIResponseException, APIMapperException {
        Result seriesResult = sendGetRequest("series/" + seriesId);
        return apiMapper.deserialize(seriesResult, Series.class);
    }

    /**
     * Retrieve paginated information about a Series by sending request to API
     *
     * @param pageNum The page number of the gallery
     * @return {@link Response} of {@link PaginationData} with {@link FilteredSeries}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<PaginationData<FilteredSeries>> getSeriesByPage(String pageNum) throws APIResponseException, APIMapperException {
        Result seriesPageResult = sendGetRequest("series?page=" + pageNum);
        return apiMapper.deserializeToPaginationData(seriesPageResult, paginationData(FilteredSeries.class));
    }

    /**
     * Retrieve the List of Anime that Aired in a given Season and Year by sending request to API
     *
     * @param season The specified season from {@link Season}
     * @param year The specified year
     * @return {@link Response} of {@link List} with {@link FilteredSeries}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredSeries>> getAllSeries(Season season, Integer year) throws APIResponseException, APIMapperException {
        Result allSeriesResult = sendGetRequest("airing/" + season.getSeason() + "/" + year);
        return apiMapper.deserializeToList(allSeriesResult, listOf(FilteredSeries.class));
    }

    /**
     * Retrieve a set of Waifus for a given {@link Series} by sending request to API
     *
     * @param seriesId The id of the {@link Series}
     * @return {@link Response} of {@link List} with {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredWaifu>> getSeriesWaifus(String seriesId) throws APIResponseException, APIMapperException {
        Result allWaifusFromSeriesResults = sendGetRequest("series/" + seriesId + "/waifus");
        return apiMapper.deserializeToList(allWaifusFromSeriesResults, listOf(FilteredWaifu.class));
    }

    /**
     * Retrieve information about the {@link User} by sending request to API
     *
     * @param userId The id of the {@link User}
     * @return {@link Response} of {@link User}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<User> getUserProfile(String userId) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendGetRequest("user/" + userId);
        return apiMapper.deserialize(userProfileResult, User.class);
    }

    /**
     * Retrieve the Waifus Created, Liked, or Trashed for the given {@link User} id by sending request to API
     *
     * @param userId The id of the {@link User}
     * @param listType The specified action E.g {@link WaifuListType#LIKED}
     * @param pageNum The page number of the gallery
     * @return {@link Response} of {@link PaginationData} with {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<PaginationData<FilteredWaifu>> getUserWaifus(String userId, String listType, String pageNum) throws APIResponseException, APIMapperException {
        Result userWaifusResult = sendGetRequest("user/" + userId + "/" + listType + "?page=" + pageNum);
        return apiMapper.deserializeToPaginationData(userWaifusResult, paginationData(FilteredWaifu.class));
    }

    /**
     * Retrieve a List of all {@link UserList}'s shown by sending request to API
     *
     * @param userId The id of the {@link User}
     * @return {@link Response} of {@link List} with {@link UserList}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<UserList>> getUserLists(String userId) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendGetRequest("user/" + userId + "/lists");
        return apiMapper.deserializeToList(userProfileResult, listOf(UserList.class));
    }

    /**
     * Retrieve the Specific {@link UserList}, with {@link Waifu}'s by sending request to API
     *
     * @param userId The id of the {@link User}
     * @param listId The id of the {@link UserList}
     * @return {@link Response} of {@link UserList}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<UserList> getUserList(String userId, String listId) throws APIResponseException, APIMapperException {
        Result userProfileResult = sendGetRequest("user/" + userId + "/lists/" + listId);
        return apiMapper.deserialize(userProfileResult, UserList.class);
    }

    /**
     * Retrieve a List of {@link FilteredWaifu}'s given a query, by sending POST request to API
     *
     * @param waifuName The name of the Waifu
     * @return {@link Response} of {@link FilteredWaifu}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredWaifu>> searchWaifus(String waifuName) throws APIMapperException, APIResponseException {
        Result searchWaifusResult = sendPostRequest("search/waifus", Map.of("term", waifuName));
        return apiMapper.deserializeToList(searchWaifusResult, listOf(FilteredWaifu.class));
    }

    /**
     * Retrieve a List of {@link FilteredSeries}'s given a query, by sending POST request to API
     *
     * @param seriesName The name of the Series
     * @return {@link Response} of {@link FilteredSeries}
     * @throws APIResponseException If {@link APIWrapper} could not return information properly
     * @throws APIMapperException If {@link APIMapper} could not correctly {@code deserialize} model
     *
     */
    Response<List<FilteredSeries>> searchSeries(String seriesName) throws APIMapperException, APIResponseException {
        Result searchSeriesResult = sendPostRequest("search/series", Map.of("term", seriesName));
        return apiMapper.deserializeToList(searchSeriesResult, listOf(FilteredSeries.class));
    }

    void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    String getApiKey() {
        return apiKey;
    }
}
