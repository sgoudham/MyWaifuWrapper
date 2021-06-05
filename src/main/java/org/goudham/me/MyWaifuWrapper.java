package org.goudham.me;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


/**
 * Returns API information to {@link MyWaifuClient}
 */
class MyWaifuWrapper {
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

    private void sendRequest(HttpClient httpClient, String param) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + param))
                .version(httpClient.version())
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .header("apikey", apiKey)
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response);

//        String resultBody = "";
//        int resultStatusCode = 0;
//        try {
//            resultBody = response.thenApply(HttpResponse::body).get();
//            resultStatusCode = response.thenApply(HttpResponse::statusCode).get();
//
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(resultStatusCode);
//        System.out.println(resultBody);
//
//        try {
//            JsonNode parent = objectMapper.readTree(resultBody);
//            String waifuData = parent.get("data").toString();
//            Waifu waifu = objectMapper.readValue(waifuData, Waifu.class);
//            System.out.println(waifu);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }

    void getWaifu(HttpClient httpClient, String param) {
        sendRequest(httpClient, "waifu/" + param);
    }
}
