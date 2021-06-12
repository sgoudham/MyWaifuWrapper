package me.goudham.domain.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

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
public class Links {
    /**
     * First page of the gallery
     *
     */
    @JsonProperty("first")
    @JsonPropertyDescription("First page of the gallery")
    private String first;

    /**
     * Last page of the gallery
     *
     */
    @JsonProperty("last")
    @JsonPropertyDescription("Last page of the gallery")
    private String last;

    /**
     * Next page of the gallery
     *
     */
    @JsonProperty("next")
    @JsonPropertyDescription("Next page of the gallery")
    private String next;

    /**
     * Previous page of the gallery
     *
     */
    @JsonProperty("prev")
    @JsonPropertyDescription("Previous page of the gallery")
    private String prev;

    @JsonProperty("first")
    public String getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(String first) {
        this.first = first;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    @JsonProperty("prev")
    public String getPrev() {
        return prev;
    }

    @JsonProperty("prev")
    public void setPrev(String prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(first, links.first) && Objects.equals(last, links.last) && Objects.equals(next, links.next) && Objects.equals(prev, links.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, next, prev);
    }

    @Override
    public String toString() {
        return "Links{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", next='" + next + '\'' +
                ", prev='" + prev + '\'' +
                '}';
    }
}
