package me.goudham.domain.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * {@link Meta}
 * <p>Contains standard Pagination data from the API</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Integer currentPage}</li>
 *  <li>{@link Integer from}</li>
 *  <li>{@link Integer lastPage}</li>
 *  <li>{@link String path}</li>
 *  <li>{@link Integer perPage}</li>
 *  <li>{@link Integer to}</li>
 *  <li>{@link Integer total}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "current_page",
        "from",
        "last_page",
        "path",
        "per_page",
        "to",
        "total"
})
record Meta(@JsonProperty("current_page") String currentPage,
            Integer from,
            @JsonProperty("last_page") Integer lastPage,
            String path,
            @JsonProperty("per_page") Integer perPage,
            Integer to,
            Integer total) { }
