package me.goudham.api.entity.waifu;

import com.fasterxml.jackson.annotation.*;
import me.goudham.api.entity.series.FilteredSeries;

import java.util.List;
import java.util.Objects;


/**
 * Filtered Waifu
 * <p>Contains Waifu data structure for endpoints other than the primary endpoint (/waifu/{slug})</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String slug}</li>
 *  <li>{@link String name}</li>
 *  <li>{@link String originalName}</li>
 *  <li>{@link Integer relevance}</li>
 *  <li>{@link String romaji}</li>
 *  <li>{@link String romajiName}</li>
 *  <li>{@link String displayPicture}</li>
 *  <li>{@link Integer likes}</li>
 *  <li>{@link Integer trash}</li>
 *  <li>{@link String type}</li>
 *  <li>{@link String url}</li>
 *  <li>{@link List} of {@link FilteredSeries}'s</li>
 *  <li>{@link Double id}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "slug",
        "name",
        "original_name",
        "relevance",
        "romaji",
        "romaji_name",
        "display_picture",
        "description",
        "likes",
        "trash",
        "type",
        "url",
        "appearances",
        "id"
})
@JsonIgnoreProperties(value = { "series" })
public class FilteredWaifu {
    /**
     * Used to generate readable URL's for the {@link FilteredWaifu}
     *
     */
    @JsonProperty("slug")
    @JsonPropertyDescription("Used to generate readable URL's for the FilteredWaifu")
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
     * Relevancy of {@link FilteredWaifu}
     */
    @JsonProperty("relevance")
    @JsonPropertyDescription("Relevancy of FilteredWaifu")
    private Integer relevance;

    /**
     * If this character has a romaji name, we'll put it here.
     *
     */
    @JsonProperty("romaji")
    @JsonPropertyDescription("if this character has a romaji name, we'll put it here. ")
    private String romaji;

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
     * Truncated, spoiler-free description of this {@link FilteredWaifu}
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Truncated, spoiler-free description of this FilteredWaifu")
    private String description;

    /**
     * Number of likes for this {@link FilteredWaifu}
     *
     */
    @JsonProperty("likes")
    @JsonPropertyDescription("Number of likes for this FilteredWaifu")
    private Integer likes;

    /**
     * Number of trashes for this {@link FilteredWaifu}
     *
     */
    @JsonProperty("trash")
    @JsonPropertyDescription("Number of trashes for this FilteredWaifu")
    private Integer trash;

    /**
     * Type that is returned. Eg Waifu, Husbando
     *
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type that is returned. Eg Waifu, Husbando")
    private String type;

    /**
     * URL to view in browser
     *
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL to view in browser")
    private String url;

    /**
     * <p>{@link List} of Waifu's appearances</p>
     */
    @JsonProperty("appearances")
    private List<FilteredSeries> appearances;

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

    @JsonProperty("relevance")
    public Integer getRelevance() { return relevance; }

    @JsonProperty("relevance")
    public void setRelevance(Integer relevance) { this.relevance = relevance; }

    @JsonProperty("romaji")
    public String getRomaji() { return romaji; }

    @JsonProperty("romaji")
    public void setRomaji(String romaji) { this.romaji = romaji; }

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

    @JsonProperty("type")
    public String getType() { return type; }

    @JsonProperty("type")
    public void setType(String type) { this.type = type; }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("appearances")
    public List<FilteredSeries> getAppearances() { return appearances; }

    @JsonProperty("appearances")
    public void setAppearances(List<FilteredSeries> filteredSeries) {
        this.appearances = filteredSeries;
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
        return Objects.equals(slug, that.slug) && Objects.equals(name, that.name) && Objects.equals(originalName, that.originalName) && Objects.equals(relevance, that.relevance) && Objects.equals(romaji, that.romaji) && Objects.equals(romajiName, that.romajiName) && Objects.equals(displayPicture, that.displayPicture) && Objects.equals(description, that.description) && Objects.equals(likes, that.likes) && Objects.equals(trash, that.trash) && Objects.equals(type, that.type) && Objects.equals(url, that.url) && Objects.equals(appearances, that.appearances) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, name, originalName, relevance, romaji, romajiName, displayPicture, description, likes, trash, type, url, appearances, id);
    }

    @Override
    public String toString() {
        return "FilteredWaifu{" +
                "slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", relevance=" + relevance +
                ", romaji='" + romaji + '\'' +
                ", romajiName='" + romajiName + '\'' +
                ", displayPicture='" + displayPicture + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", trash=" + trash +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", appearances=" + appearances +
                ", id=" + id +
                '}';
    }
}