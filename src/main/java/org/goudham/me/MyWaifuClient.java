package org.goudham.me;

import org.goudham.me.api.entity.series.FilteredSeries;
import org.goudham.me.api.entity.series.Series;
import org.goudham.me.api.entity.waifu.Waifu;
import org.goudham.me.exception.APIMapperException;
import org.goudham.me.exception.APIResponseException;
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
    MyWaifuClient(@NotNull String apiKey, HttpClient httpClient) {
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

    public Response<Series> getSeries(@NotNull Integer id) throws APIMapperException, APIResponseException {
        return APIWrapper.getSeries(String.valueOf(id));
    }

    public Response<List<FilteredSeries>> getAiringAnime() throws APIMapperException, APIResponseException {
        return APIWrapper.getAiringAnime();
    }

    /**
     * Builder for MyWaifuClient
     */
    public static class Builder {
        private final String apiKey;
        private final HttpClient.Builder httpClientBuilder = HttpClient.newBuilder();

        public Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        public Builder withCookieHandler(CookieHandler cookieHandler) {
            httpClientBuilder.cookieHandler(cookieHandler);
            return this;
        }

        public Builder withConnectTimeout(Duration duration) {
            httpClientBuilder.connectTimeout(duration);
            return this;
        }

        public Builder withSslParameters(SSLParameters sslParameters) {
            httpClientBuilder.sslParameters(sslParameters);
            return this;
        }

        public Builder withExecutor(Executor executor) {
            httpClientBuilder.executor(executor);
            return this;
        }

        public Builder withFollowRedirects(HttpClient.Redirect policy) {
            httpClientBuilder.followRedirects(policy);
            return this;
        }

        public Builder withVersion(HttpClient.Version version) {
            httpClientBuilder.version(version);
            return this;
        }

        public Builder withPriority(int priority) {
            httpClientBuilder.priority(priority);
            return this;
        }

        public Builder withProxy(ProxySelector proxySelector) {
            httpClientBuilder.proxy(proxySelector);
            return this;
        }

        public Builder withAuthenticator(Authenticator authenticator) {
            httpClientBuilder.authenticator(authenticator);
            return this;
        }

        public MyWaifuClient build() {
            return new MyWaifuClient(apiKey, httpClientBuilder.build());
        }
    }
}
