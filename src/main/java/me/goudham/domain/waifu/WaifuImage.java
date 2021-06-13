package me.goudham.domain.waifu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

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
public class WaifuImage {

    /**
     * ID in the database
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("ID in the database")
    private Integer id;

    /**
     * URL of the thumbnail to display
     *
     */
    @JsonProperty("thumbnail")
    @JsonPropertyDescription("URL of the thumbnail to display")
    private String thumbnail;

    /**
     * Final URL of the original resolution image
     *
     */
    @JsonProperty("image")
    @JsonPropertyDescription("Final URL of the original resolution image")
    private String image;

    /**
     * If image is NSFW or not
     *
     */
    @JsonProperty("nsfw")
    @JsonPropertyDescription("If image is NSFW or not")
    private String nsfw;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("nsfw")
    public String getNsfw() { return nsfw; }

    @JsonProperty("nsfw")
    public void setNsfw(String nsfw) { this.nsfw = nsfw; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaifuImage that = (WaifuImage) o;
        return Objects.equals(id, that.id) && Objects.equals(thumbnail, that.thumbnail) && Objects.equals(image, that.image) && Objects.equals(nsfw, that.nsfw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thumbnail, image, nsfw);
    }

    @Override
    public String toString() {
        return "WaifuImage{" +
                "id=" + id +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                ", nsfw='" + nsfw + '\'' +
                '}';
    }
}

