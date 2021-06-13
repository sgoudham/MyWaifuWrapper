package me.goudham;

import me.goudham.exception.APIResponseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class APIWrapperTest {

    @Mock
    private
    HttpClient httpClient;

    private APIWrapper sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new APIWrapper("ValidAPIKey", httpClient);
    }

    @Test
    void successfullyReturn400WhenApiTokenInvalid() throws APIResponseException, IOException, InterruptedException {
        sut.setApiKey("InvalidAPIKey");
        HttpRequest expectedHttpRequest = buildHttpRequest(sut);
        HttpResponse<String> expectedHttpResponse = build400HttpResponse();

        doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
        doReturn(HttpClient.Version.HTTP_2).when(httpClient).version();

        Result actualResult = sut.sendRequest("waifu/1");

        assertThat(actualResult.getStatusCode(), is(400));
        assertThat(actualResult.getBody(), is("{\"message\":\"Access denied - please check your token\",\"code\":400}"));
        verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
        verify(httpClient, times(1)).version();
        verifyNoMoreInteractions(httpClient);
    }

    private HttpRequest buildHttpRequest(APIWrapper sut) {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://mywaifulist.moe/api/v1/waifu/1"))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.ofSeconds(20))
                .headers("Content-Type", "application/json", "apikey", sut.getApiKey())
                .GET()
                .build();
    }

    private HttpResponse<String> build400HttpResponse() {
        return new HttpResponse<>() {
            @Override
            public int statusCode() {
                return 400;
            }

            @Override
            public HttpRequest request() {
                return null;
            }

            @Override
            public Optional<HttpResponse<String>> previousResponse() {
                return Optional.empty();
            }

            @Override
            public HttpHeaders headers() {
                return null;
            }

            @Override
            public String body() {
                return "{\"message\":\"Access denied - please check your token\",\"code\":400}";
            }

            @Override
            public Optional<SSLSession> sslSession() {
                return Optional.empty();
            }

            @Override
            public URI uri() {
                return null;
            }

            @Override
            public HttpClient.Version version() {
                return null;
            }
        };
    }
}