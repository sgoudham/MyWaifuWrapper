package org.goudham.me.api.entity.series;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.goudham.me.api.entity.Studio;
import org.goudham.me.api.entity.waifu.Waifu;

import java.util.Objects;

/**
 * {@link Series}
 * <p>Represents a grouping of various {@link Waifu}'s. This can be an anime, mobile game, video game, manga, or LN</p>
 *
 * <p> Fields included are: </p>
 * <li>{@link String name}</li>
 * <li>{@link String originalName}</li>
 * <li>{@link String romajiName}</li>
 * <li>{@link String slug}</li>
 * <li>{@link String releaseDate}</li>
 * <li>{@link String airingStart}</li>
 * <li>{@link String airingEnd}</li>
 * <li>{@link Integer episodeCount}</li>
 * <li>{@link String image}</li>
 * <li>{@link String url}</li>
 * <li>{@link Studio}</li>
 * <li>{@link Integer id}</li>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "original_name",
        "romaji_name",
        "description",
        "slug",
        "release_date",
        "airing_start",
        "airing_end",
        "episode_count",
        "image",
        "url",
        "studio",
        "id"
})
@Generated("jsonschema2pojo")
public class Series {
    /**
     * Full Name (in English)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Full Name (in English)")
    private String name;

    /**
     * Name in the original language (日本語)
     *
     */
    @JsonProperty("original_name")
    @JsonPropertyDescription("Name in the original language (\u65e5\u672c\u8a9e)")
    private String originalName;

    /**
     * Romanization of this {@link Series} name
     *
     */
    @JsonProperty("romaji_name")
    @JsonPropertyDescription("Romanization of this Series name")
    private String romajiName;

    /**
     * Spoiler-free description of the {@link Series}, work, etc
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Spoiler-free description of the series, work, etc")
    private String description;

    /**
     * Used to generate readable URL's for the {@link Series}
     *
     */
    @JsonProperty("slug")
    @JsonPropertyDescription("Used to generate readable URL's for the Series")
    private String slug;

    /**
     * Original works release date (
     *
     */
    @JsonProperty("release_date")
    @JsonPropertyDescription("Original works release date (")
    private String releaseDate;

    /**
     * The works airing start date
     *
     */
    @JsonProperty("airing_start")
    @JsonPropertyDescription("The works airing start date")
    private String airingStart;

    /**
     * The works airing end date
     *
     */
    @JsonProperty("airing_end")
    @JsonPropertyDescription("The works airing end date")
    private String airingEnd;

    /**
     * The number of episodes in this work. 1 if OVA or Movie.
     *
     */
    @JsonProperty("episode_count")
    @JsonPropertyDescription("The number of episodes in this work. 1 if OVA or Movie.")
    private Integer episodeCount;

    /**
     * URL of the display picture
     *
     */
    @JsonProperty("image")
    @JsonPropertyDescription("URL of the display picture")
    private String image;

    /**
     * URL of the {@link Series}
     */
    @JsonProperty("url")
    private String url;

    /**
     * {@link Studio}
     * <p>
     * Contains information on a given animation or game development studio
     *
     */
    @JsonProperty("studio")
    @JsonPropertyDescription("Contains information on a given animation or game development studio")
    private Studio studio;

    /**
     * The internal ID of the {@link Series}
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The internal ID of the Series")
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAiringStart() {
        return airingStart;
    }

    public void setAiringStart(String airingStart) {
        this.airingStart = airingStart;
    }

    @JsonProperty("airing_end")
    public String getAiringEnd() {
        return airingEnd;
    }

    @JsonProperty("airing_end")
    public void setAiringEnd(String airingEnd) {
        this.airingEnd = airingEnd;
    }

    @JsonProperty("episode_count")
    public Integer getEpisodeCount() {
        return episodeCount;
    }

    @JsonProperty("episode_count")
    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("studio")
    public Studio getStudio() {
        return studio;
    }

    @JsonProperty("studio")
    public void setStudio(Studio studio) {
        this.studio = studio;
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
        Series series = (Series) o;
        return Objects.equals(name, series.name) && Objects.equals(originalName, series.originalName) && Objects.equals(romajiName, series.romajiName) && Objects.equals(description, series.description) && Objects.equals(slug, series.slug) && Objects.equals(releaseDate, series.releaseDate) && Objects.equals(airingStart, series.airingStart) && Objects.equals(airingEnd, series.airingEnd) && Objects.equals(episodeCount, series.episodeCount) && Objects.equals(image, series.image) && Objects.equals(url, series.url) && Objects.equals(studio, series.studio) && Objects.equals(id, series.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, originalName, romajiName, description, slug, releaseDate, airingStart, airingEnd, episodeCount, image, url, studio, id);
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", romajiName='" + romajiName + '\'' +
                ", description='" + description + '\'' +
                ", slug='" + slug + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", airingStart='" + airingStart + '\'' +
                ", airingEnd='" + airingEnd + '\'' +
                ", episodeCount=" + episodeCount +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", studio=" + studio +
                ", id=" + id +
                '}';
    }
}