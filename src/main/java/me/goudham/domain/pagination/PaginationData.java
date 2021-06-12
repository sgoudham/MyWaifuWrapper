package me.goudham.domain.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
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
public class PaginationData<T> {

    /**
     * Data returned from the gallery
     *
     */
    @JsonProperty("data")
    @JsonPropertyDescription("Data returned from the gallery")
    private List<T> data;

    /**
     * {@link Links} to other data within the gallery
     *
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Links to other data within the gallery")
    private Links links;

    /**
     * Extra pagination information
     *
     */
    @JsonProperty("meta")
    @JsonPropertyDescription("Extra pagination information")
    private Meta meta;

    @JsonProperty("data")
    public List<T> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<T> data) {
        this.data = data;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}