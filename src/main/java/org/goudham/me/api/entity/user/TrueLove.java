
package org.goudham.me.api.entity.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.goudham.me.api.entity.series.Series;

import javax.annotation.processing.Generated;
import java.util.Objects;

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
@Generated("jsonschema2pojo")
public class TrueLove {
    /**
     * Name of {@link TrueLove}
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of True Love")
    private String name;

    /**
     * Slug value of {@link TrueLove}
     */
    @JsonProperty("slug")
    @JsonPropertyDescription("Slug value of True Love")
    private String slug;

    /**
     * {@link Series} that this {@link TrueLove} is part of
     */
    @JsonProperty("series")
    @JsonPropertyDescription("Series that this TrueLove is part of")
    private String series;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("series")
    public String getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrueLove trueLove = (TrueLove) o;
        return Objects.equals(name, trueLove.name) && Objects.equals(slug, trueLove.slug) && Objects.equals(series, trueLove.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug, series);
    }

    @Override
    public String toString() {
        return "TrueLove{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}