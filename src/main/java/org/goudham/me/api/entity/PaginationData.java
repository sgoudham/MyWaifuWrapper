package org.goudham.me.api.entity;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * {@link PaginationData}
 * <p>Contains standard Pagination data from the API</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Integer currentPage}</li>
 *  <li>{@link Integer lastPage}</li>
 *  <li>{@link Integer perPage}</li>
 *  <li>{@link Integer total}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "current_page",
        "last_page",
        "per_page",
        "total"
})
@Generated("jsonschema2pojo")
public class PaginationData {
    /**
     * Current requested page
     *
     */
    @JsonProperty("current_page")
    @JsonPropertyDescription("Current requested page")
    private Integer currentPage;

    /**
     * Last available page
     *
     */
    @JsonProperty("last_page")
    @JsonPropertyDescription("Last available page")
    private Integer lastPage;

    /**
     * Total number of items per page
     *
     */
    @JsonProperty("per_page")
    @JsonPropertyDescription("Total number of items per page")
    private Integer perPage;

    /**
     * Total number of items
     *
     */
    @JsonProperty("total")
    @JsonPropertyDescription("Total number of items")
    private Integer total;

    @JsonProperty("current_page")
    public Integer getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("current_page")
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("last_page")
    public Integer getLastPage() {
        return lastPage;
    }

    @JsonProperty("last_page")
    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

}
