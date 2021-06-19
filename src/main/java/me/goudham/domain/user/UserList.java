package me.goudham.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import me.goudham.domain.waifu.Waifu;

import java.util.List;

/**
 * {@link UserList}
 * <p>Get an array of all Waifu lists on their profile</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String name}</li>
 *  <li>{@link Integer order}</li>
 *  <li>{@link List} of {@link Waifu}'s</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "order",
        "waifus"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserList(Integer id, String name, Integer order, List<Waifu> waifus) { }