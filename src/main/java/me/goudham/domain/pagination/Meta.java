package me.goudham.domain.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;


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
public class Meta {
    /**
     * Current requested page
     *
     */
    @JsonProperty("current_page")
    @JsonPropertyDescription("Current requested page")
    private Integer currentPage;

    /**
     * Starting gallery image number
     *
     */
    @JsonProperty("from")
    @JsonPropertyDescription("Starting gallery image number")
    private Integer from;

    /**
     * Last available page
     *
     */
    @JsonProperty("last_page")
    @JsonPropertyDescription("Last available page")
    private Integer lastPage;

    /**
     * API url for gallery
     *
     */
    @JsonProperty("path")
    @JsonPropertyDescription("API url for gallery")
    private String path;

    /**
     * Total number of items per page
     *
     */
    @JsonProperty("per_page")
    @JsonPropertyDescription("Total number of items per page")
    private Integer perPage;

    /**
     * Last gallery image number
     *
     */
    @JsonProperty("to")
    @JsonPropertyDescription("Last gallery image number")
    private Integer to;

    /**
     * Total number of items within the gallery
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

    @JsonProperty("from")
    public Integer getFrom() { return from; }

    @JsonProperty("from")
    public void setFrom(Integer from) { this.from = from; }

    @JsonProperty("last_page")
    public Integer getLastPage() {
        return lastPage;
    }

    @JsonProperty("last_page")
    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    @JsonProperty("path")
    public String getPath() { return path; }

    @JsonProperty("path")
    public void setPath(String path) { this.path = path; }

    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @JsonProperty("to")
    public Integer getTo() { return to; }

    @JsonProperty("to")
    public void setTo(Integer to) { this.to = to; }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return Objects.equals(currentPage, meta.currentPage) && Objects.equals(from, meta.from) && Objects.equals(lastPage, meta.lastPage) && Objects.equals(path, meta.path) && Objects.equals(perPage, meta.perPage) && Objects.equals(to, meta.to) && Objects.equals(total, meta.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPage, from, lastPage, path, perPage, to, total);
    }

    @Override
    public String toString() {
        return "Meta{" +
                "currentPage=" + currentPage +
                ", from=" + from +
                ", lastPage=" + lastPage +
                ", path=" + path +
                ", perPage=" + perPage +
                ", to=" + to +
                ", total=" + total +
                '}';
    }
}
