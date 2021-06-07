package org.goudham.me;

import org.goudham.me.api.entity.series.Series;
import org.goudham.me.api.entity.waifu.Waifu;

/**
 * This is returned to the User when called by methods in {@link MyWaifuClient}.
 * E.g {@link MyWaifuClient#getWaifu(Integer)}
 * <br>
 * Given a successful response, {@link #entity} will be populated with the requested entity.
 * <br>
 * No matter successful or unsuccessful response, {@link #responseCode} and {@link #responseBody}
 * will be populated to ensure the user has all the information for debugging or extra information within
 * the {@link #responseBody}
 *
 * @param <T> The type of entity to be returned. E.g {@link Waifu} or {@link Series}
 *
 */
public class Response<T> {
    private T entity;
    private final Integer responseCode;
    private final String responseBody;

    Response(Integer responseCode, String responseBody, T entity) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.entity = entity;
    }

    Response(Integer responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public T getEntity() {
        return entity;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
