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
    private HttpClient httpClient;

    /**
     * Creates an instance of {@link MyWaifuClient}
     *
     * <p>See <a href="https://mywaifulist.docs.stoplight.io/">MyWaifuList</a> for obtaining an API Key</p>
     * @param apiKey API Key to authorise API request
     */
    MyWaifuClient(@NotNull String apiKey) {
        APIWrapper = new APIWrapper(apiKey);
    }

    /**
     * Creates an instance of {@link MyWaifuClient} with default {@link HttpClient} settings
     *
     * @param apiKey API Key to authorise API request
     * @return {@link MyWaifuClient}
     */
    public static MyWaifuClient createDefault(@NotNull String apiKey) {
        MyWaifuClient myWaifuClient = new MyWaifuClient(apiKey);
        myWaifuClient.setHttpClient(HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build());

        return myWaifuClient;
    }

    public Response<Waifu> getWaifu(String slug) throws APIResponseException, APIMapperException {
        return APIWrapper.getWaifu(httpClient, slug);
    }

    public Response<Waifu> getWaifu(Integer id) throws APIResponseException, APIMapperException {
        return APIWrapper.getWaifu(httpClient, String.valueOf(id));
    }

    public Response<Series> getSeries(Integer id) throws APIMapperException, APIResponseException {
        return APIWrapper.getSeries(httpClient, String.valueOf(id));
    }

    public Response<List<FilteredSeries>> getAiringAnime() throws APIMapperException, APIResponseException {
        return APIWrapper.getAiringAnime(httpClient);
    }

    /**
     * Sets an instance of HttpClient
     *
     * @param httpClient HttpClient for executing API requests
     */
    void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Builder for MyWaifuClient
     */
    public static class Builder {
        private final String apiKey;
        private final APIWrapper APIWrapper;
        private HttpClient.Builder httpClientBuilder;

        public Builder(String apiKey) {
            this.apiKey = apiKey;
            APIWrapper = new APIWrapper(apiKey);
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
            MyWaifuClient myWaifuClient = new MyWaifuClient(apiKey);
            myWaifuClient.setHttpClient(httpClientBuilder.build());
            return myWaifuClient;
        }
    }
}
