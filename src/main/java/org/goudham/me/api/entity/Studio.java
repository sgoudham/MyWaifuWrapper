package org.goudham.me.api.entity;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * {@link Studio}
 * <p> Contains information on a given animation or game development studio </p>
 *
 * <p>Fields included are:</p>
 * <li>{@link Integer id}</li>
 * <li>{@link String name}</li>
 * <li>{@link String originalName}</li>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "original_name"
})
@Generated("jsonschema2pojo")
public class Studio {
    /**
     * {@link Studio} ID
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Studio ID")
    private Integer id;

    /**
     * {@link Studio} Name
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Studio Name")
    private String name;

    /**
     * {@link Studio}'s Original Name
     */
    @JsonProperty("original_name")
    @JsonPropertyDescription("Studio's Original Name")
    private String originalName;

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

    @JsonProperty("original_name")
    public String getOriginalName() {
        return originalName;
    }

    @JsonProperty("original_name")
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio studio = (Studio) o;
        return Objects.equals(id, studio.id) && Objects.equals(name, studio.name) && Objects.equals(originalName, studio.originalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originalName);
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                '}';
    }
}

