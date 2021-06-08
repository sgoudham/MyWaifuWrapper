package me.goudham;

import me.goudham.api.entity.series.Series;
import me.goudham.api.entity.waifu.Waifu;

/**
 * This is returned to the User when called by methods in {@link MyWaifuClient}.
 * E.g {@link MyWaifuClient#getWaifu(Integer)}
 * <br>
 * Given a successful response, {@link #entity} will be populated with the requested entity.
 * <br>
 * No matter successful or unsuccessful response, {@link #statusCode} and {@link #body}
 * will be populated to ensure the user has all the information for debugging or extra information within
 * the {@link #body}
 *
 * @param <T> The type of entity to be returned. E.g {@link Waifu} or {@link Series}
 *
 */
public class Response<T> {
    private final T entity;
    private final Integer statusCode;
    private final String body;

    Response(Integer statusCode, String body, T entity) {
        this.statusCode = statusCode;
        this.body = body;
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
