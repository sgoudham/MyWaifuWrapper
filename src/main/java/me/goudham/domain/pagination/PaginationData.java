package me.goudham.domain.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * {@link PaginationData}
 * <p>Contains standard Pagination data from the API including images</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Object data}</li>
 *  <li>{@link Links links}</li>
 *  <li>{@link Meta meta}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "links",
        "meta"
})
public record PaginationData<T>(List<T> data, Links links, Meta meta) { }