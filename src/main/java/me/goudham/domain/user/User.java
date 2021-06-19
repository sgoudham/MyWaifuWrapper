package me.goudham.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * {@link User}
 * <p>Standard user information and counts of waifus created, liked, trashed. Also contains true love</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link String avatar}</li>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String name}</li>
 *  <li>{@link String twitter}</li>
 *  <li>{@link String joined}</li>
 *  <li>{@link Integer waifusCreated}</li>
 *  <li>{@link Integer waifusLiked}</li>
 *  <li>{@link Integer waifusTrashed}</li>
 *  <li>{@link TrueLove trueLove}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "avatar",
        "id",
        "name",
        "twitter",
        "joined",
        "waifus_created",
        "waifus_liked",
        "waifus_trashed",
        "true_love"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
        String avatar,
        Integer id,
        String name,
        String twitter,
        String joined,
        @JsonProperty("waifus_created") Integer waifusCreated,
        @JsonProperty("waifus_liked") Integer waifusLiked,
        @JsonProperty("waifus_trashed") Integer waifusTrashed,
        @JsonProperty("true_love") TrueLove trueLove
) { }
