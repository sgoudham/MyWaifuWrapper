package org.goudham.me.api.entity.user;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.goudham.me.api.entity.waifu.Waifu;

import java.util.Objects;


/**
 * {@link User}
 * <p>Standard user information and counts of waifus created, liked, trashed. Also contains true love</p>
 *
 * <p> Fields included are: </p>
 * <ul>
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
        "id",
        "name",
        "twitter",
        "joined",
        "waifus_created",
        "waifus_liked",
        "waifus_trashed",
        "true_love"
})
@Generated("jsonschema2pojo")
public class User {

    /**
     * {@link User} ID
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * {@link User}'s display name, or twitter name
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("User's display name, or twitter name")
    private String name;

    /**
     * {@link User}'s Twitter Handle
     *
     */
    @JsonProperty("twitter")
    @JsonPropertyDescription("User's Twitter Handle")
    private String twitter;

    /**
     * ISO 8601 date when {@link User} joined
     *
     */
    @JsonProperty("joined")
    @JsonPropertyDescription("ISO 8601 date when user joined")
    private String joined;

    /**
     * Number of {@link Waifu}'s this {@link User} has created
     *
     */
    @JsonProperty("waifus_created")
    @JsonPropertyDescription("Number of Waifu's this user has created")
    private Integer waifusCreated;

    /**
     * Number of {@link Waifu}'s this {@link User} has liked
     *
     */
    @JsonProperty("waifus_liked")
    @JsonPropertyDescription("Number of Waifu's this user has liked")
    private Integer waifusLiked;

    /**
     * Number of {@link Waifu}'s this {@link User} has trashed
     *
     */
    @JsonProperty("waifus_trashed")
    @JsonPropertyDescription("Number of Waifu's this user has trashed")
    private Integer waifusTrashed;

    /**
     * <p>User's {@link TrueLove}</p>
     */
    @JsonProperty("true_love")
    private TrueLove trueLove;

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

    @JsonProperty("twitter")
    public String getTwitter() {
        return twitter;
    }

    @JsonProperty("twitter")
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @JsonProperty("joined")
    public String getJoined() {
        return joined;
    }

    @JsonProperty("joined")
    public void setJoined(String joined) {
        this.joined = joined;
    }

    @JsonProperty("waifus_created")
    public Integer getWaifusCreated() {
        return waifusCreated;
    }

    @JsonProperty("waifus_created")
    public void setWaifusCreated(Integer waifusCreated) {
        this.waifusCreated = waifusCreated;
    }

    @JsonProperty("waifus_liked")
    public Integer getWaifusLiked() {
        return waifusLiked;
    }

    @JsonProperty("waifus_liked")
    public void setWaifusLiked(Integer waifusLiked) {
        this.waifusLiked = waifusLiked;
    }

    @JsonProperty("waifus_trashed")
    public Integer getWaifusTrashed() {
        return waifusTrashed;
    }

    @JsonProperty("waifus_trashed")
    public void setWaifusTrashed(Integer waifusTrashed) {
        this.waifusTrashed = waifusTrashed;
    }

    @JsonProperty("true_love")
    public TrueLove getTrueLove() {
        return trueLove;
    }

    @JsonProperty("true_love")
    public void setTrueLove(TrueLove trueLove) {
        this.trueLove = trueLove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(twitter, user.twitter) && Objects.equals(joined, user.joined) && Objects.equals(waifusCreated, user.waifusCreated) && Objects.equals(waifusLiked, user.waifusLiked) && Objects.equals(waifusTrashed, user.waifusTrashed) && Objects.equals(trueLove, user.trueLove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, twitter, joined, waifusCreated, waifusLiked, waifusTrashed, trueLove);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twitter='" + twitter + '\'' +
                ", joined='" + joined + '\'' +
                ", waifusCreated=" + waifusCreated +
                ", waifusLiked=" + waifusLiked +
                ", waifusTrashed=" + waifusTrashed +
                ", trueLove=" + trueLove +
                '}';
    }
}
