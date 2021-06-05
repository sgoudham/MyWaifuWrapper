package org.goudham.me.api.entity.waifu;

import java.util.List;
import java.util.Objects;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Filtered Waifu
 * <p>Contains Waifu data structure for endpoints other than the primary endpoint (/waifu/{slug})</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String slug}</li>
 *  <li>{@link String name}</li>
 *  <li>{@link String originalName}</li>
 *  <li>{@link String romajiName}</li>
 *  <li>{@link String displayPicture}</li>
 *  <li>{@link Integer likes}</li>
 *  <li>{@link Integer trash}</li>
 *  <li>{@link Integer episodeCount}</li>
 *  <li>{@link String url}</li>
 *  <li>{@link List} of {@link Appearance}'s</li>
 *  <li>{@link Double id}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "slug",
        "name",
        "original_name",
        "romaji_name",
        "display_picture",
        "description",
        "likes",
        "trash",
        "url",
        "appearances",
        "id"
})
@Generated("jsonschema2pojo")
public class FilteredWaifu {
    /**
     * Used to generate readable URL's for the Waifu
     *
     */
    @JsonProperty("slug")
    @JsonPropertyDescription("Used to generate readable URL's for the Waifu")
    private String slug;

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
     * If this character has a romaji name, we'll put it here.
     *
     */
    @JsonProperty("romaji_name")
    @JsonPropertyDescription("if this character has a romaji name, we'll put it here. ")
    private String romajiName;

    /**
     * URL of the display picture
     *
     */
    @JsonProperty("display_picture")
    @JsonPropertyDescription("URL of the display picture")
    private String displayPicture;

    /**
     * Truncated, spoiler-free description of this Waifu
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Truncated, spoiler-free description of this Waifu")
    private String description;

    /**
     * Number of likes for this Waifu
     *
     */
    @JsonProperty("likes")
    @JsonPropertyDescription("Number of likes for this Waifu")
    private Integer likes;

    /**
     * Number of trashes for this Waifu
     *
     */
    @JsonProperty("trash")
    @JsonPropertyDescription("Number of trashes for this Waifu")
    private Integer trash;

    /**
     * URL to view in browser
     *
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL to view in browser")
    private String url;

    /**
     * <p>{@link List<Appearance>} of Waifu's {@link Appearance}</p>
     */
    @JsonProperty("appearances")
    private List<Appearance> appearances;

    /**
     * {@link FilteredWaifu} ID
     */
    @JsonProperty("id")
    private Double id;

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }


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

    @JsonProperty("display_picture")
    public String getDisplayPicture() {
        return displayPicture;
    }

    @JsonProperty("display_picture")
    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("likes")
    public Integer getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @JsonProperty("trash")
    public Integer getTrash() {
        return trash;
    }

    @JsonProperty("trash")
    public void setTrash(Integer trash) {
        this.trash = trash;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("appearances")
    public List<Appearance> getAppearances() {
        return appearances;
    }

    @JsonProperty("appearances")
    public void setAppearances(List<Appearance> appearances) {
        this.appearances = appearances;
    }

    @JsonProperty("id")
    public Double getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Double id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilteredWaifu that = (FilteredWaifu) o;
        return Objects.equals(slug, that.slug) && Objects.equals(name, that.name) && Objects.equals(originalName, that.originalName) && Objects.equals(romajiName, that.romajiName) && Objects.equals(displayPicture, that.displayPicture) && Objects.equals(description, that.description) && Objects.equals(likes, that.likes) && Objects.equals(trash, that.trash) && Objects.equals(url, that.url) && Objects.equals(appearances, that.appearances) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, name, originalName, romajiName, displayPicture, description, likes, trash, url, appearances, id);
    }

    @Override
    public String toString() {
        return "FilteredWaifu{" +
                "slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", romajiName='" + romajiName + '\'' +
                ", displayPicture='" + displayPicture + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", trash=" + trash +
                ", url='" + url + '\'' +
                ", appearances=" + appearances +
                ", id=" + id +
                '}';
    }
}