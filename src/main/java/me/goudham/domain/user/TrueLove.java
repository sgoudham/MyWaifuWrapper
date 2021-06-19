
package me.goudham.domain.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * {@link TrueLove}
 * <p>Represents a {@link User}'s True Love</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String name}</li>
 *  <li>{@link String slug}</li>
 *  <li>{@link String series}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "slug",
        "series"
})
record TrueLove(String name, String slug, String series) { }