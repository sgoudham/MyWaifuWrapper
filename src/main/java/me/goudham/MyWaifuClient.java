package me.goudham;

import me.goudham.util.Season;
import me.goudham.api.entity.series.FilteredSeries;
import me.goudham.api.entity.series.Series;
import me.goudham.api.entity.user.User;
import me.goudham.api.entity.waifu.FilteredWaifu;
import me.goudham.api.entity.waifu.Waifu;
import me.goudham.exception.APIMapperException;
import me.goudham.exception.APIResponseException;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.SSLParameters;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * A MyWaifuClient, the underlying client used for making requests is {@link HttpClient}
 *
 *
 * <p> Main entry point for retrieving information from MyWaifuList.</p>
 * <p> {@link APIWrapper} is utilised to make the API requests </p>
 */
public class MyWaifuClient {
    private final APIWrapper APIWrapper;

    /**
     * Creates an instance of {@link MyWaifuClient}
     *
     * <p>See <a href="https://mywaifulist.docs.stoplight.io/">MyWaifuList</a> for obtaining an API Key</p>
     * @param apiKey API Key to authorise API request
     * @param httpClient The underlying {@link HttpClient} to use for HttpRequests
     *
     */
    MyWaifuClient(@NotNull String apiKey, @NotNull HttpClient httpClient) {
        APIWrapper = new APIWrapper(apiKey, httpClient);
    }

    /**
     * Creates an instance of {@link MyWaifuClient} with default {@link HttpClient} settings
     *
     * @param apiKey API Key to authorise API request
     * @return {@link MyWaifuClient}
     */
    public static MyWaifuClient createDefault(@NotNull String apiKey) {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        return new MyWaifuClient(apiKey, httpClient);
    }

    public Response<Waifu> getWaifu(@NotNull String slug) throws APIResponseException, APIMapperException {
        return APIWrapper.getWaifu(slug);
    }

    public Response<Waifu> getWaifu(@NotNull Integer id) throws APIResponseException, APIMapperException {
        return APIWrapper.getWaifu(String.valueOf(id));
    }

    public Response<FilteredWaifu> getDailyWaifu() throws APIResponseException, APIMapperException {
        return APIWrapper.getDailyWaifu();
    }

    public Response<FilteredWaifu> getRandomWaifu() throws APIResponseException, APIMapperException {
        return APIWrapper.getRandomWaifu();
    }

    public Response<Series> getSeries(@NotNull String param) throws APIMapperException, APIResponseException {
        return APIWrapper.getSeries(param);
    }

    public Response<Series> getSeries(@NotNull Integer id) throws APIMapperException, APIResponseException {
        return APIWrapper.getSeries(String.valueOf(id));
    }

    public Response<List<FilteredSeries>> getSeasonalAnime() throws APIMapperException, APIResponseException {
        return APIWrapper.getSeasonalAnime();
    }

    public Response<List<FilteredWaifu>> getBestWaifus() throws APIMapperException, APIResponseException {
        return APIWrapper.getBestWaifus();
    }

    public Response<List<FilteredWaifu>> getPopularWaifus() throws APIMapperException, APIResponseException {
        return APIWrapper.getPopularWaifus();
    }

    public Response<List<FilteredWaifu>> getTrashWaifus() throws APIMapperException, APIResponseException {
        return APIWrapper.getTrashWaifus();
    }

    public Response<List<FilteredSeries>> getAllSeries(@NotNull Season season, @NotNull Integer year) throws APIResponseException, APIMapperException {
        return APIWrapper.getAllSeries(season, year);
    }

    public Response<List<FilteredWaifu>> getSeriesWaifus(@NotNull String slug) throws APIMapperException, APIResponseException {
        return APIWrapper.getSeriesWaifus(slug);
    }

    public Response<List<FilteredWaifu>> getSeriesWaifus(@NotNull Integer id) throws APIMapperException, APIResponseException {
        return APIWrapper.getSeriesWaifus(String.valueOf(id));
    }

    public Response<User> getUserProfile(@NotNull Integer id) throws APIMapperException, APIResponseException {
        return APIWrapper.getUserProfile(String.valueOf(id));
    }

    /**
     * Builder for {@link MyWaifuClient}
     *
     */
    public static class Builder {
        private final String apiKey;
        private final HttpClient.Builder httpClientBuilder = HttpClient.newBuilder();

        public Builder(@NotNull String apiKey) {
            this.apiKey = apiKey;
        }

        public Builder withCookieHandler(CookieHandler cookieHandler) {
            httpClientBuilder.cookieHandler(cookieHandler);
            return this;
        }

        public Builder withConnectTimeout(@NotNull Duration duration) {
            httpClientBuilder.connectTimeout(duration);
            return this;
        }

        public Builder withSslParameters(@NotNull SSLParameters sslParameters) {
            httpClientBuilder.sslParameters(sslParameters);
            return this;
        }

        public Builder withExecutor(@NotNull Executor executor) {
            httpClientBuilder.executor(executor);
            return this;
        }

        public Builder withFollowRedirects(@NotNull HttpClient.Redirect policy) {
            httpClientBuilder.followRedirects(policy);
            return this;
        }

        public Builder withVersion(@NotNull HttpClient.Version version) {
            httpClientBuilder.version(version);
            return this;
        }

        public Builder withPriority(int priority) {
            httpClientBuilder.priority(priority);
            return this;
        }

        public Builder withProxy(@NotNull ProxySelector proxySelector) {
            httpClientBuilder.proxy(proxySelector);
            return this;
        }

        public Builder withAuthenticator(@NotNull Authenticator authenticator) {
            httpClientBuilder.authenticator(authenticator);
            return this;
        }

        public MyWaifuClient build() {
            return new MyWaifuClient(apiKey, httpClientBuilder.build());
        }
    }
}
