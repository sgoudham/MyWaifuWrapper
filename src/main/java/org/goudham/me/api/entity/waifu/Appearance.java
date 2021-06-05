package org.goudham.me.api.entity.waifu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;


/**
 * {@link Appearance}
 * <p>Contains basic series information for most endpoints</p>
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
public class Appearance {
    @JsonProperty("name")
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    @JsonProperty("romaji_name")
    private String romajiName;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
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

}
