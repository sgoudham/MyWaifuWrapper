package me.goudham;

import me.goudham.domain.series.Series;
import me.goudham.domain.waifu.Waifu;

/**
 * This is returned to the User when called by methods in {@link MyWaifuClient}.
 * E.g {@link MyWaifuClient#getWaifu(Integer)}
 * <br>
 * Given a successful response, {@link #model} will be populated with the requested model.
 * <br>
 * No matter successful or unsuccessful response, {@link #statusCode} and {@link #body}
 * will be populated to ensure the user has all the information for debugging or extra information within
 * the {@link #body}
 *
 * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
 *
 */
public class Response<T> {
    private final T model;
    private final Integer statusCode;
    private final String body;

    Response(Integer statusCode, String body, T model) {
        this.statusCode = statusCode;
        this.body = body;
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
