package me.goudham.api.entity.user;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import me.goudham.api.entity.waifu.Waifu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * {@link Creator}
 * <p>User that submitted the {@link Waifu}</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String id}</li>
 *  <li>{@link String name}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
@Generated("jsonschema2pojo")
public class Creator {

    /**
     * {@link Creator} ID
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("")
    private Integer id;

    /**
     * {@link Creator} Name
     */
    @JsonProperty("name")
    @JsonPropertyDescription("")
    private String name;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creator creator = (Creator) o;
        return Objects.equals(id, creator.id) && Objects.equals(name, creator.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Creator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}