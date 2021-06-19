package me.goudham.domain.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import me.goudham.domain.waifu.Waifu;

/**
 * {@link Creator}
 * <p>User that submitted the {@link Waifu}</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String id}</li>
 *  <li>{@link String name}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
public record Creator(Integer id, String name) { }