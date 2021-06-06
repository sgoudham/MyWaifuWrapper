package org.goudham.me;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.goudham.me.api.entity.waifu.Waifu;
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
     *
     *
     * @param httpClient The {@link HttpClient} to use for sending {@link HttpRequest}'s
     * @param param The end of the endpoint appended onto the host
     */
    private Result sendRequest(HttpClient httpClient, String param) throws APIResponseException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + param))
                .version(httpClient.version())
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .header("apikey", apiKey)
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

    Response<Waifu> getWaifu(HttpClient httpClient, String param) throws APIResponseException {
        Result waifuResult = sendRequest(httpClient, "waifu/" + param);
        Integer statusCode = waifuResult.getStatusCode();
        String body = waifuResult.getBody();
        Waifu waifu = null;

        if (statusCode == 200) {
            try {
                JsonNode parent = objectMapper.readTree(body);
                String waifuData = parent.get("data").toString();
                waifu = objectMapper.readValue(waifuData, Waifu.class);
            } catch (JsonProcessingException jpe) {
                jpe.printStackTrace();

                statusCode = 100;
                body = "{\"message\":\"If you are seeing this message, this is more than likely a fault in my logic. " +
                        "Please raise an issue with the printed stacktrace :D\",\"code\":Custom 100}";
            }
        }

        return new Response<>(statusCode, body, waifu);
    }
}
