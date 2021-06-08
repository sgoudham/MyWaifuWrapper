package org.goudham.me;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.goudham.me.api.entity.series.FilteredSeries;
import org.goudham.me.api.entity.series.Series;
import org.goudham.me.api.entity.waifu.Waifu;
import org.goudham.me.exception.APIMapperException;

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

    /**
     * Using the given {@code entity}, {@link ObjectMapper} deserializes the given Json
     * into a Java POJO
     *
     * @param result The result of the previous API response
     * @param entity The actual class of the given entity. E.g {@link Waifu#getClass()}
     * @param <T> The type of entity to be returned. E.g {@link Waifu} or {@link Series}
     * @return {@link Response}
     * @throws APIMapperException If {@link ObjectMapper} is not able to deserialize JSON to Java POJO properly
     *
     */
    <T> Response<T> deserialize(Result result, Class<T> entity) throws APIMapperException {
        Integer statusCode = result.getStatusCode();
        String body = result.getBody();
        T newEntity = null;

        if (statusCode == 200) {
            try {
                String data = getJsonTree(body);
                newEntity = objectMapper.readValue(data, entity);
            } catch (JsonProcessingException jpe) {
                throwAPIMapperException(jpe);
            }
        }

        return new Response<>(statusCode, body, newEntity);
    }

    /**
     * Using the given {@code entity}, {@link ObjectMapper} deserializes the given Json
     * into a Java POJO. This method enables support for retrieving {@link List} of entities
     *
     * @param <T> List of entities to be returned. E.g {@link List} of {@link FilteredSeries}
     * @param result The result of the previous API response
     * @param entity The actual class of the given entity. E.g {@link Waifu#getClass()}
     * @return {@link Response}
     * @throws APIMapperException If {@link ObjectMapper} is not able to deserialize JSON to Java POJO properly
     */
    <T> Response<List<T>> deserialize(Result result, JavaType entity) throws APIMapperException {
        Integer statusCode = result.getStatusCode();
        String body = result.getBody();
        List<T> listOfEntity = null;

        if (statusCode == 200) {
            try {
                String data = getJsonTree(body);
                listOfEntity = objectMapper.readValue(data, entity);
            } catch (JsonProcessingException jpe) {
                throwAPIMapperException(jpe);
            }
        }

        return new Response<>(statusCode, body, listOfEntity);
    }

    /**
     * Helper method for reducing duplicate code in {@code deserialize()}
     * and {@code deserializeToList()}
     * <br>
     * Returns the proper json data to deserialize
     *
     * @param jsonBody jsonBody returned by the API
     * @return {@link String}
     * @throws JsonProcessingException If {@link ObjectMapper} is not able to
     * read the given {@code jsonBody}
     */
    private String getJsonTree(String jsonBody) throws JsonProcessingException {
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
