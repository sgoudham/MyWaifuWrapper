package me.goudham.api.entity.waifu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * {@link WaifuImage}
 * <p>Contains a thumbnail and full res image link for an image in a given Waifu’s gallery</p>
 *
 * <p>Fields included are:</p>
 * <ul>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String thumbnail}</li>
 *  <li>{@link String path}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "thumbnail",
        "path"
})
@Generated("jsonschema2pojo")
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
    @JsonProperty("path")
    @JsonPropertyDescription("Final URL of the original resolution image")
    private String path;

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

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaifuImage that = (WaifuImage) o;
        return Objects.equals(id, that.id) && Objects.equals(thumbnail, that.thumbnail) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thumbnail, path);
    }

    @Override
    public String toString() {
        return "WaifuImage{" +
                "id=" + id +
                ", thumbnail='" + thumbnail + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}

