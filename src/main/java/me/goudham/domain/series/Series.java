package me.goudham.domain.series;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import me.goudham.domain.Studio;
import me.goudham.domain.waifu.Waifu;

/**
 * {@link Series}
 * <p>Represents a grouping of various {@link Waifu}'s. This can be an anime, mobile game, video game, manga, or LN</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String name}</li>
 *  <li>{@link String originalName}</li>
 *  <li>{@link String romajiName}</li>
 *  <li>{@link String description}</li>
 *  <li>{@link String slug}</li>
 *  <li>{@link String releaseDate}</li>
 *  <li>{@link String airingStart}</li>
 *  <li>{@link String airingEnd}</li>
 *  <li>{@link Integer episodeCount}</li>
 *  <li>{@link String displayPicture}</li>
 *  <li>{@link String url}</li>
 *  <li>{@link Studio}</li>
 *  <li>{@link String type}</li>
 *  <li>{@link Integer id}</li>
 * </ul>
 *
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
        "display_picture",
        "url",
        "studio",
        "type",
        "id"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public record Series(
        String name,
        @JsonProperty("original_name") String originalName,
        @JsonProperty("romaji_name") String romajiName,
        String description,
        String slug,
        @JsonProperty("release_date") String releaseDate,
        @JsonProperty("airing_start") String airingStart,
        @JsonProperty("airing_end") String airing_end,
        @JsonProperty("episode_count") Integer episodeCount,
        @JsonProperty("display_picture") String displayPicture,
        String url,
        Studio studio,
        String type,
        Integer id
) { }