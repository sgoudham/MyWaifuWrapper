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
 * @param statusCode The status code returned by the API Response
 * @param body The body returned by the the API Response
 * @param <T> The type of model to be returned. E.g {@link Waifu} or {@link Series}
 *
 */
public record Response<T>(Integer statusCode, String body, T model) { }
