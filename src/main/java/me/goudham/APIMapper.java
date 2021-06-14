package me.goudham;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.goudham.domain.pagination.PaginationData;
import me.goudham.domain.series.Series;
import me.goudham.domain.waifu.Waifu;
import me.goudham.exception.APIMapperException;

import java.util.List;

/**
 * Maps API Information to Java POJO's
 *
 */
class APIMapper {
    private final ObjectMapper objectMapper;

    APIMapper() {
        objectMapper = new ObjectMapper();
    }

    String getValueAsString(Object obj) throws APIMapperException {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException jpe) {
            throw new APIMapperException(jpe.getMessage(), jpe);
        }
    }

    /**
     * Using the given {@code model}, {@link ObjectMapper} deserializes the given Json
     * into a Java POJO
     *
     * @param result The result of the previous API response
     * @param model The actual class of the given model. E.g {@link Waifu#getClass()}
     * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link Response}
     * @throws APIMapperException If {@link ObjectMapper} is not able to deserialize JSON to Java POJO properly
     *
     */
    <T> Response<T> deserialize(Result result, Class<T> model) throws APIMapperException {
        Integer statusCode = result.getStatusCode();
        String body = result.getBody();
        T newModel = null;

        if (statusCode == 200) {
            try {
                String data = getData(body);
                newModel = objectMapper.readValue(data, model);
            } catch (JsonProcessingException jpe) {
                throwAPIMapperException(jpe);
            }
        }

        return new Response<>(statusCode, body, newModel);
    }

    /**
     * Using the given {@code model}, {@link ObjectMapper} deserializes the given Json
     * into a Java POJO. This method enables support for retrieving {@link List} of models
     *
     * @param result The result of the previous API response
     * @param model The actual class of the given model. E.g {@link Waifu#getClass()}
     * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link Response}
     * @throws APIMapperException If {@link ObjectMapper} is not able to deserialize JSON to Java POJO properly
     */
    <T> Response<List<T>> deserializeToList(Result result, JavaType model) throws APIMapperException {
        Integer statusCode = result.getStatusCode();
        String body = result.getBody();
        List<T> listOfModels = null;

        if (statusCode == 200) {
            try {
                String data = getData(body);
                listOfModels = objectMapper.readValue(data, model);
            } catch (JsonProcessingException jpe) {
                throwAPIMapperException(jpe);
            }
        }

        return new Response<>(statusCode, body, listOfModels);
    }

    /**
     * Using the given {@code model}, {@link ObjectMapper} deserializes the given Json
     * into a Java POJO. This method enables support for retrieving {@link PaginationData} of specific models
     *
     * @param result The result of the previous API response
     * @param model The actual class of the given model. E.g {@link Waifu#getClass()}
     * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link Response}
     * @throws APIMapperException If {@link ObjectMapper} is not able to deserialize JSON to Java POJO properly
     */
    <T> Response<PaginationData<T>> deserializeToPaginationData(Result result, JavaType model) throws APIMapperException {
        Integer statusCode = result.getStatusCode();
        String body = result.getBody();
        PaginationData<T> newModel = null;

        if (statusCode == 200) {
            try {
                newModel = objectMapper.readValue(body, model);
            } catch (JsonProcessingException jpe) {
                throwAPIMapperException(jpe);
            }
        }

        return new Response<>(statusCode, body, newModel);
    }

    /**
     * Helper method for reducing duplicate code in {@code deserialize()}
     * and {@code deserializeToList()}
     *
     * @param jsonBody jsonBody returned by the API
     * @return {@link String} — The proper json data to deserialize
     * @throws JsonProcessingException If {@link ObjectMapper} is not able to
     * read the given {@code jsonBody}
     */
    private String getData(String jsonBody) throws JsonProcessingException {
        JsonNode parent = objectMapper.readTree(jsonBody);
        return parent.get("data").toString();
    }


    /**
     * Helper method for reducing duplicate code in {@code deserialize()}
     * and {@code deserializeToList()}
     *
     * @param throwable Type of throwable to throw
     * @throws APIMapperException Purpose of the method
     */
    private void throwAPIMapperException(Throwable throwable) throws APIMapperException {
        String customExceptionMessage = "If you are seeing this message, " +
                "this is more than likely a fault in my logic. " +
                "Please raise an issue including the printed stacktrace :D";
        String exceptionMessage = "\n\n" + customExceptionMessage + "\n\n" + throwable.getMessage();

        throw new APIMapperException(exceptionMessage, throwable);
    }
}
