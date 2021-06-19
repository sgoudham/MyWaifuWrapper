package me.goudham.domain.waifu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import me.goudham.domain.series.FilteredSeries;

import java.util.List;


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
 *  <li>{@link String description}</li>
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
@JsonIgnoreProperties(ignoreUnknown = true)
public record FilteredWaifu(
        String slug,
        String name,
        @JsonProperty("original_name") String originalName,
        Integer relevance,
        String romaji,
        @JsonProperty("romaji_name") String romajiName,
        @JsonProperty("display_picture") String displayPicture,
        String description,
        Integer likes,
        Integer trash,
        String type,
        String url,
        List<FilteredSeries> appearances,
        Double id
) { }