package me.goudham.domain.waifu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * {@link WaifuImage}
 * <p>Contains a thumbnail and full res image link for an image in a given Waifu’s gallery</p>
 *
 * <p>Fields included are:</p>
 * <ul>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String thumbnail}</li>
 *  <li>{@link String image}</li>
 *  <li>{@link Boolean nsfw}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "thumbnail",
        "image",
        "nsfw"
})
public record WaifuImage(Integer id, String thumbnail, String image, Boolean nsfw) { }

