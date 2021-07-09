package me.goudham;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.goudham.domain.pagination.PaginationData;
import me.goudham.domain.waifu.FilteredWaifu;
import me.goudham.domain.waifu.Waifu;
import me.goudham.domain.waifu.WaifuImage;
import me.goudham.exception.APIMapperException;
import me.goudham.exception.APIResponseException;
import me.goudham.util.TestEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static me.goudham.APIUtils.listOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MyWaifuClientTest {

	@Mock
	private HttpClient httpClient;

	@Spy
	private ObjectMapper objectMapper;

	private final String apiKey = "ValidAPIKey";

	private MyWaifuClient sut;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		sut = MyWaifuClient.createDefault(apiKey);
		APIWrapper apiWrapper = new APIWrapper(apiKey, httpClient);
		APIMapper apiMapper = new APIMapper();

		apiMapper.setObjectMapper(objectMapper);
		apiWrapper.setApiMapper(apiMapper);
		sut.setAPIWrapper(apiWrapper);
	}

	@Test
	void successfullyGetWaifu() throws IOException, InterruptedException, APIMapperException, APIResponseException {
		HttpRequest expectedHttpRequest = buildHttpGetRequest(apiKey, "waifu/1");
		int expectedStatusCode = 200;
		String expectedBody = getJsonAsString("getWaifu.json");
		Waifu expectedWaifu = TestEntity.getExpectedWaifu();
		HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

		doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());

		Response<Waifu> actualWaifuResponse = sut.getWaifu(1);

		assertThat(actualWaifuResponse.getStatusCode(), is(expectedStatusCode));
		assertThat(actualWaifuResponse.getBody(), is(expectedBody));
		assertThat(actualWaifuResponse.getModel(), is(expectedWaifu));
		verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
		verifyNoMoreInteractions(httpClient);
	}

	@Test
	void successfullyGetBestWaifus() throws IOException, InterruptedException, APIMapperException, APIResponseException {
		HttpRequest expectedHttpRequest = buildHttpGetRequest(apiKey, "airing/best");
		int expectedStatusCode = 200;
		String expectedBody = getJsonAsString("getBestWaifus.json");
		List<FilteredWaifu> expectedBestWaifus = TestEntity.getBestWaifus();
		HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

		doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());

		Response<List<FilteredWaifu>> actualBestWaifusResponse = sut.getBestWaifus();

		assertThat(actualBestWaifusResponse.getStatusCode(), is(expectedStatusCode));
		assertThat(actualBestWaifusResponse.getBody(), is(expectedBody));
		assertThat(actualBestWaifusResponse.getModel(), is(expectedBestWaifus));
		verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
		verifyNoMoreInteractions(httpClient);
	}

	@Test
	void successfullyGetWaifuImages() throws IOException, InterruptedException, APIMapperException, APIResponseException {
		HttpRequest expectedHttpRequest = buildHttpGetRequest(apiKey, "waifu/1/images?page=1");
		int expectedStatusCode = 200;
		String expectedBody = getJsonAsString("getWaifuImages.json");
		PaginationData<WaifuImage> expectedWaifuImages = TestEntity.getWaifuImages();
		HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

		doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());

		Response<PaginationData<WaifuImage>> actualWaifuImagesResponse = sut.getWaifuImages(1, 1);

		assertThat(actualWaifuImagesResponse.getStatusCode(), is(expectedStatusCode));
		assertThat(actualWaifuImagesResponse.getBody(), is(expectedBody));
		assertThat(actualWaifuImagesResponse.getModel(), is(expectedWaifuImages));
		verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
		verifyNoMoreInteractions(httpClient);
	}

	@Test
	void successfullyPostBetaSearch() throws IOException, InterruptedException, APIMapperException, APIResponseException {
		HttpRequest expectedHttpRequest = buildHttpPostRequest(apiKey, "search/beta");
		int expectedStatusCode = 200;
		String expectedBody = getJsonAsString("betaSearch.json");
		List<FilteredWaifu> expectedBetaSearch = TestEntity.getBetaSearch();
		HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

		doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());

		Response<List<FilteredWaifu>> actualBetaSearchResponse = sut.betaSearch("Yumeko");

		assertThat(actualBetaSearchResponse.getStatusCode(), is(expectedStatusCode));
		assertThat(actualBetaSearchResponse.getBody(), is(expectedBody));
		assertThat(actualBetaSearchResponse.getModel(), is(expectedBetaSearch));
		verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
		verifyNoMoreInteractions(httpClient);
	}

	@Test
	void failToGetBestWaifusWhereDeserializationGoesWrong() throws IOException, InterruptedException {
		HttpRequest expectedHttpRequest = buildHttpGetRequest(apiKey, "airing/best");
		int expectedStatusCode = 200;
		String expectedBody = getJsonAsString("getBestWaifus.json");
		String expectedData = getData(expectedBody);
		HttpResponse<String> expectedHttpResponse = buildHttpResponse(expectedStatusCode, expectedBody);

		JavaType expectedModel = listOf(FilteredWaifu.class);
		String customExceptionMessage = "If you are seeing this message, " +
				"this is more than likely a fault in my logic. " +
				"Please raise an issue including the printed stacktrace :D";
		String exceptionMessage = "Uh Oh Somebody Did a No No!";
		String expectedExceptionMessage = "\n\n" + customExceptionMessage + "\n\n" + exceptionMessage;

		doReturn(expectedHttpResponse).when(httpClient).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
		doThrow(new JsonProcessingException(exceptionMessage) {}).when(objectMapper).readValue(expectedData, expectedModel);

		Throwable actualException = assertThrows(APIMapperException.class, () -> sut.getBestWaifus());

		assertThat(actualException.getMessage(), is(expectedExceptionMessage));
		verify(httpClient, times(1)).send(expectedHttpRequest, HttpResponse.BodyHandlers.ofString());
		verifyNoMoreInteractions(httpClient);
	}

	private String getData(String jsonBody) throws JsonProcessingException {
		JsonNode parent = objectMapper.readTree(jsonBody);
		return parent.get("data").toString();
	}

	private HttpRequest buildHttpPostRequest(String apiKey, String param) {
		return HttpRequest.newBuilder()
				.uri(URI.create("https://mywaifulist.moe/api/v1/" + param))
				.timeout(Duration.ofSeconds(20))
				.headers("Content-Type", "application/json", "apikey", apiKey)
				.POST(HttpRequest.BodyPublishers.ofString(""))
				.build();
	}


	private String getJsonAsString(String filename) {
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		return new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream), StandardCharsets.UTF_8))
				.lines()
				.collect(Collectors.joining("\n"));
	}

	private HttpRequest buildHttpGetRequest(String apiKey, String param) {
		return HttpRequest.newBuilder()
				.uri(URI.create("https://mywaifulist.moe/api/v1/" + param))
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

