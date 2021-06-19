package me.goudham.domain.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * {@link Links}
 * <p>Contains gallery API links for {@link Meta}</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String first}</li>
 *  <li>{@link String last}</li>
 *  <li>{@link String next}</li>
 *  <li>{@link String prev}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "first",
        "last",
        "next",
        "prev"
})
record Links(String first, String last, String next, String prev) { }
