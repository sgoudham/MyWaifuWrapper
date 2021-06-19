package me.goudham.domain.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * {@link FilteredSeries}
 * <p> Contains basic series information for most endpoints </p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String name}</li>
 *  <li>{@link String originalName}</li>
 *  <li>{@link Integer relevance}</li>
 *  <li>{@link String romajiName}</li>
 *  <li>{@link String slug}</li>
 *  <li>{@link String} type</li>
 *  <li>{@link String description}</li>
 *  <li>{@link String displayPicture}</li>
 *  <li>{@link String url}</li>
 *  <li>{@link Integer id}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "original_name",
        "relevance",
        "romaji_name",
        "slug",
        "type",
        "description",
        "display_picture",
        "url",
        "id"
})
public record FilteredSeries(
        String name,
        @JsonProperty("original_name") String originalName,
        Integer relevance,
        @JsonProperty("romaji_name") String romajiName,
        String slug,
        String type,
        String description,
        @JsonProperty("display_picture") String displayPicture,
        String url,
        Integer id
) { }
