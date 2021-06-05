package org.goudham.me.api.entity.series;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;


/**
 * {@link FilteredSeries}
 * <p> Contains basic series information for most endpoints </p>
 *
 * <p> Fields included are: </p>
 * <li>{@link String name}</li>
 * <li>{@link String originalName}</li>
 * <li>{@link String romajiName}</li>
 * <li>{@link String slug}</li>
 * <li>{@link String description}</li>
 * <li>{@link String url}</li>
 * <li>{@link Integer id}</li>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "original_name",
        "romaji_name",
        "slug",
        "description",
        "url",
        "id"
})
@Generated("jsonschema2pojo")
public class FilteredSeries {
    /**
     * Full name, in English.
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Full name, in English.")
    private String name;

    /**
     * Name in the original language (日本語)
     *
     */
    @JsonProperty("original_name")
    @JsonPropertyDescription("Name in the original language (\u65e5\u672c\u8a9e)")
    private String originalName;

    /**
     * If this {@link Series} has a romaji name, we'll put it here.
     *
     */
    @JsonProperty("romaji_name")
    @JsonPropertyDescription("if this character has a romaji name, we'll put it here. ")
    private String romajiName;

    /**
     * Readable URL's for this {@link Series}
     *
     */
    @JsonProperty("slug")
    @JsonPropertyDescription("Used to generate readable URL's for the Waifu")
    private String slug;


    /**
     * Truncated, spoiler-free description of this {@link Series}
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Truncated, spoiler-free description of this Waifu")
    private String description;

    /**
     * URL to view in browser
     *
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL to view in browser")
    private String url;

    /**
     * Interal ID of this {@link Series}
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Internal ID of the series")
    private Integer id;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("original_name")
    public String getOriginalName() {
        return originalName;
    }

    @JsonProperty("original_name")
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @JsonProperty("romaji_name")
    public String getRomajiName() {
        return romajiName;
    }

    @JsonProperty("romaji_name")
    public void setRomajiName(String romajiName) {
        this.romajiName = romajiName;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilteredSeries that = (FilteredSeries) o;
        return Objects.equals(name, that.name) && Objects.equals(originalName, that.originalName) && Objects.equals(romajiName, that.romajiName) && Objects.equals(slug, that.slug) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, originalName, romajiName, slug, description, url, id);
    }

    @Override
    public String toString() {
        return "FilteredSeries{" +
                "name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", romajiName='" + romajiName + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                '}';
    }
}
