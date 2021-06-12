package me.goudham.domain.user;

import com.fasterxml.jackson.annotation.*;
import me.goudham.domain.waifu.Waifu;

import java.util.List;
import java.util.Objects;

/**
 * {@link UserList}
 * <p>Get an array of all Waifu lists on their profile</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String name}</li>
 *  <li>{@link Integer order}</li>
 *  <li>{@link List} of {@link Waifu}'s</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "order",
        "waifus"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserList {
    /**
     * {@link UserList} ID
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("UserList ID")
    private Integer id;

    /**
     * {@link UserList} Name
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("UserList Name")
    private String name;

    /**
     * Order this appears in the {@link UserList}
     *
     */
    @JsonProperty("order")
    @JsonPropertyDescription("Order this appears in the UserList")
    private Integer order;

    /**
     * List of {@link Waifu}'s within the {@link UserList}
     *
     */
    @JsonProperty("waifus")
    @JsonPropertyDescription("List of Waifu's within the UserList")
    private List<Waifu> waifus;

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

    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("waifus")
    public List<Waifu> getWaifus() {
        return waifus;
    }

    @JsonProperty("waifus")
    public void setWaifus(List<Waifu> waifus) {
        this.waifus = waifus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList = (UserList) o;
        return Objects.equals(id, userList.id) && Objects.equals(name, userList.name) && Objects.equals(order, userList.order) && Objects.equals(waifus, userList.waifus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, order, waifus);
    }

    @Override
    public String toString() {
        return "UserList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", waifus=" + waifus +
                '}';
    }
}