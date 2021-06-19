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
        HttpRequest expectedHttpRequest = buildHttpRequest("InvalidAPIKey");
        int expectedStatusCode = 400;
        String expectedBody = "{\"message\":\"Access denied - please check your token\",\"code\":400}";
        HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

        doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());

        sut.setApiKey("InvalidAPIKey");
        Result actualResult = sut.sendGetRequest("waifu/1");

        assertThat(actualResult.statusCode(), is(expectedStatusCode));
        assertThat(actualResult.body(), is(expectedBody));
        verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    void successfullyReturn200WhenApiTokenValid() throws APIResponseException, IOException, InterruptedException {
        HttpRequest expectedHttpRequest = buildHttpRequest("ValidAPIKey");
        int expectedStatusCode = 200;
        String expectedBody = "{\"message\":\"Token Valid\",\"code\":200}";
        HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

        doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());

        Result actualResult = sut.sendGetRequest("waifu/1");

        assertThat(actualResult.statusCode(), is(expectedStatusCode));
        assertThat(actualResult.body(), is(expectedBody));
        verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
        verifyNoMoreInteractions(httpClient);
    }

    private HttpRequest buildHttpRequest(String apiKey) {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://mywaifulist.moe/api/v1/waifu/1"))
                .timeout(Duration.ofSeconds(20))
                .headers("Content-Type", "application/json", "apikey", apiKey)
                .GET()
                .build();
    }

    private HttpResponse<String> buildHttpResponse(int statusCode, String body) {
        return new HttpResponse<>() {
            @Override
            public int statusCode() {
                return statusCode;
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
                return body;
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