package me.goudham.api.entity.waifu;

import com.fasterxml.jackson.annotation.*;
import me.goudham.api.entity.series.Series;
import me.goudham.api.entity.user.Creator;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * {@link Waifu}
 * <p>Contains most common attributes for {@link Waifu}'s based on various source material</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String slug}</li>
 *  <li>{@link Creator creatorId}</li>
 *  <li>{@link String name}</li>
 *  <li>{@link String originalName}</li>
 *  <li>{@link String romaji_name}</li>
 *  <li>{@link String displayPicture}</li>
 *  <li>{@link String description}</li>
 *  <li>{@link Double weight}</li>
 *  <li>{@link Double height}</li>
 *  <li>{@link Double bust}</li>
 *  <li>{@link Double hip}</li>
 *  <li>{@link Double waist}</li>
 *  <li>{@link Waifu.BloodType bloodType}</li>
 *  <li>{@link String origin}</li>
 *  <li>{@link Integer age}</li>
 *  <li>{@link String birthdayMonth}</li>
 *  <li>{@link Integer birthdayDay}</li>
 *  <li>{@link Integer birthdayYear}</li>
 *  <li>{@link Integer likes}</li>
 *  <li>{@link Integer trash}</li>
 *  <li>{@link String url}</li>
 *  <li>{@link Boolean husbando}</li>
 *  <li>{@link Boolean nsfw}</li>
 *  <li>{@link Integer popularityRank}</li>
 *  <li>{@link Integer likeRank}</li>
 *  <li>{@link Integer trashRank}</li>
 *  <li>{@link List} of {@link Series}'s</li>
 *  <li>{@link Series series}</li>
 * </ul>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "slug",
        "creator",
        "name",
        "original_name",
        "romaji_name",
        "display_picture",
        "description",
        "weight",
        "height",
        "bust",
        "hip",
        "waist",
        "blood_type",
        "origin",
        "age",
        "birthday_month",
        "birthday_day",
        "birthday_year",
        "likes",
        "trash",
        "url",
        "husbando",
        "nsfw",
        "popularity_rank",
        "like_rank",
        "trash_rank",
        "appearances",
        "series"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Waifu {
    /**
     * {@link Waifu} ID
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("ID of this Waifu")
    private Integer id;

    /**
     * Used to generate readable URL's for the {@link Waifu}
     *
     */
    @JsonProperty("slug")
    @JsonPropertyDescription("Used to generate readable URL's for the Waifu")
    private String slug;

    /**
     * ID of the user who created this {@link Waifu}
     *
     */
    @JsonProperty("creator")
    @JsonPropertyDescription("User who created this Waifu")
    private Creator creator;

    /**
     * Full name, in English.
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Full name, in English.")
    private String name;

    /**
     * Name in the original language (日本語)
     *
     */
    @JsonProperty("original_name")
    @JsonPropertyDescription("Name in the original language (\u65e5\u672c\u8a9e)")
    private String originalName;

    /**
     * If this character has a romaji name, we'll put it here.
     *
     */
    @JsonProperty("romaji_name")
    @JsonPropertyDescription("if this character has a romaji name, we'll put it here. ")
    private String romajiName;

    /**
     * URL of the display picture
     *
     */
    @JsonProperty("display_picture")
    @JsonPropertyDescription("URL of the display picture")
    private String displayPicture;

    /**
     * Spoiler-free description of this {@link Waifu}
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Spoiler-free description of this Waifu")
    private String description;

    /**
     * Weight (kg)
     *
     */
    @JsonProperty("weight")
    @JsonPropertyDescription("Weight (kg)")
    private Double weight;

    /**
     * Height(cm)
     *
     */
    @JsonProperty("height")
    @JsonPropertyDescription("Height(cm)")
    private Double height;

    /**
     * Bust size (cm)
     *
     */
    @JsonProperty("bust")
    @JsonPropertyDescription("Bust size (cm)")
    private Double bust;

    /**
     * Hip size (cm)
     *
     */
    @JsonProperty("hip")
    @JsonPropertyDescription("Hip size (cm)")
    private Double hip;

    /**
     * Waist size (cm)
     *
     */
    @JsonProperty("waist")
    @JsonPropertyDescription("Waist size (cm)")
    private Double waist;

    /**
     * Common in Japanese culture as a potential reprenstation of personality types
     *
     */
    @JsonProperty("blood_type")
    @JsonPropertyDescription("Common in Japanese culture as a potential reprenstation of personality types")
    private Waifu.BloodType bloodType;

    /**
     * Birth location, home, etc.
     *
     */
    @JsonProperty("origin")
    @JsonPropertyDescription("Birth location, home, etc.")
    private String origin;

    /**
     * Age from the source material (e.g. 500 for 500 years old)
     *
     */
    @JsonProperty("age")
    @JsonPropertyDescription("Age from the source material (e.g. 500 for 500 years old)")
    private Integer age;

    /**
     * Birth month from source material
     *
     */
    @JsonProperty("birthday_month")
    @JsonPropertyDescription("Birth month from source material")
    private String birthdayMonth;

    /**
     * Birth day from source material
     *
     */
    @JsonProperty("birthday_day")
    @JsonPropertyDescription("Birth day from source material")
    private Integer birthdayDay;

    /**
     * Birth year from source material
     *
     */
    @JsonProperty("birthday_year")
    @JsonPropertyDescription("Birth year from source material")
    private Integer birthdayYear;

    /**
     * Number of likes for this {@link Waifu}
     *
     */
    @JsonProperty("likes")
    @JsonPropertyDescription("Number of likes for this Waifu")
    private Integer likes;

    /**
     * Number of trashes for this {@link Waifu}
     *
     */
    @JsonProperty("trash")
    @JsonPropertyDescription("Number of trashes for this Waifu")
    private Integer trash;

    /**
     * URL to view in browser
     *
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL to view in browser")
    private String url;

    /**
     * If this character is a husbando
     *
     */
    @JsonProperty("husbando")
    @JsonPropertyDescription("If this character is a husbando")
    private Boolean husbando;

    /**
     * If this {@link Waifu}\husbando appears in an NSFW work
     *
     */
    @JsonProperty("nsfw")
    @JsonPropertyDescription("If this waifu\\husbando appears in an NSFW work")
    private Boolean nsfw;

    /**
     * Site-wide popularity ranking
     *
     */
    @JsonProperty("popularity_rank")
    @JsonPropertyDescription("Site-wide popularity ranking")
    private Integer popularityRank;

    /**
     * Site-wide "like" or "claim" ranking
     *
     */
    @JsonProperty("like_rank")
    @JsonPropertyDescription("Site-wide \"like\" or \"claim\" ranking")
    private Integer likeRank;

    /**
     * Site-wide trash ranking - lower is worse.
     *
     */
    @JsonProperty("trash_rank")
    @JsonPropertyDescription("Site-wide trash ranking - lower is worse")
    private Integer trashRank;

    /**
     * An array of series or works that this character appears in.
     *
     */
    @JsonProperty("appearances")
    @JsonPropertyDescription("An array of series or works that this character appears in")
    private List<Series> appearances;

    /**
     * {@link Series}
     * <p>Contains basic series information for most endpoints</p>
     *
     */
    @JsonProperty("series")
    @JsonPropertyDescription("Contains basic series information for most endpoints")
    private Series series;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("creator")
    public Creator getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(Creator creator) {
        this.creator = creator;
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

    @JsonProperty("romaji_name")
    public String getRomajiName() {
        return romajiName;
    }

    @JsonProperty("romaji_name")
    public void setRomajiName(String romajiName) {
        this.romajiName = romajiName;
    }

    @JsonProperty("display_picture")
    public String getDisplayPicture() {
        return displayPicture;
    }

    @JsonProperty("display_picture")
    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @JsonProperty("height")
    public Double getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Double height) {
        this.height = height;
    }

    @JsonProperty("bust")
    public Double getBust() {
        return bust;
    }

    @JsonProperty("bust")
    public void setBust(Double bust) {
        this.bust = bust;
    }

    @JsonProperty("hip")
    public Double getHip() {
        return hip;
    }

    @JsonProperty("hip")
    public void setHip(Double hip) {
        this.hip = hip;
    }

    @JsonProperty("waist")
    public Double getWaist() {
        return waist;
    }

    @JsonProperty("waist")
    public void setWaist(Double waist) {
        this.waist = waist;
    }

    @JsonProperty("blood_type")
    public Waifu.BloodType getBloodType() {
        return bloodType;
    }

    @JsonProperty("blood_type")
    public void setBloodType(Waifu.BloodType bloodType) {
        this.bloodType = bloodType;
    }

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("birthday_month")
    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    @JsonProperty("birthday_month")
    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    @JsonProperty("birthday_day")
    public Integer getBirthdayDay() {
        return birthdayDay;
    }

    @JsonProperty("birthday_day")
    public void setBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    @JsonProperty("birthday_year")
    public Integer getBirthdayYear() {
        return birthdayYear;
    }

    @JsonProperty("birthday_year")
    public void setBirthdayYear(Integer birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    @JsonProperty("likes")
    public Integer getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @JsonProperty("trash")
    public Integer getTrash() {
        return trash;
    }

    @JsonProperty("trash")
    public void setTrash(Integer trash) {
        this.trash = trash;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("husbando")
    public Boolean getHusbando() {
        return husbando;
    }

    @JsonProperty("husbando")
    public void setHusbando(Boolean husbando) {
        this.husbando = husbando;
    }

    @JsonProperty("nsfw")
    public Boolean getNsfw() {
        return nsfw;
    }

    @JsonProperty("nsfw")
    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    @JsonProperty("popularity_rank")
    public Integer getPopularityRank() {
        return popularityRank;
    }

    @JsonProperty("popularity_rank")
    public void setPopularityRank(Integer popularityRank) {
        this.popularityRank = popularityRank;
    }

    @JsonProperty("like_rank")
    public Integer getLikeRank() {
        return likeRank;
    }

    @JsonProperty("like_rank")
    public void setLikeRank(Integer likeRank) {
        this.likeRank = likeRank;
    }

    @JsonProperty("trash_rank")
    public Integer getTrashRank() {
        return trashRank;
    }

    @JsonProperty("trash_rank")
    public void setTrashRank(Integer trashRank) {
        this.trashRank = trashRank;
    }

    @JsonProperty("appearances")
    public List<Series> getAppearances() {
        return appearances;
    }

    @JsonProperty("appearances")
    public void setAppearances(List<Series> appearances) {
        this.appearances = appearances;
    }

    @JsonProperty("series")
    public Series getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waifu waifu = (Waifu) o;
        return Objects.equals(id, waifu.id) && Objects.equals(slug, waifu.slug) && Objects.equals(creator, waifu.creator) && Objects.equals(name, waifu.name) && Objects.equals(originalName, waifu.originalName) && Objects.equals(romajiName, waifu.romajiName) && Objects.equals(displayPicture, waifu.displayPicture) && Objects.equals(description, waifu.description) && Objects.equals(weight, waifu.weight) && Objects.equals(height, waifu.height) && Objects.equals(bust, waifu.bust) && Objects.equals(hip, waifu.hip) && Objects.equals(waist, waifu.waist) && bloodType == waifu.bloodType && Objects.equals(origin, waifu.origin) && Objects.equals(age, waifu.age) && Objects.equals(birthdayMonth, waifu.birthdayMonth) && Objects.equals(birthdayDay, waifu.birthdayDay) && Objects.equals(birthdayYear, waifu.birthdayYear) && Objects.equals(likes, waifu.likes) && Objects.equals(trash, waifu.trash) && Objects.equals(url, waifu.url) && Objects.equals(husbando, waifu.husbando) && Objects.equals(nsfw, waifu.nsfw) && Objects.equals(popularityRank, waifu.popularityRank) && Objects.equals(likeRank, waifu.likeRank) && Objects.equals(trashRank, waifu.trashRank) && Objects.equals(appearances, waifu.appearances) && Objects.equals(series, waifu.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, creator, name, originalName, romajiName, displayPicture, description, weight, height, bust, hip, waist, bloodType, origin, age, birthdayMonth, birthdayDay, birthdayYear, likes, trash, url, husbando, nsfw, popularityRank, likeRank, trashRank, appearances, series);
    }

    @Override
    public String toString() {
        return "Waifu{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", creator=" + creator +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", romajiName='" + romajiName + '\'' +
                ", displayPicture='" + displayPicture + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", bust=" + bust +
                ", hip=" + hip +
                ", waist=" + waist +
                ", bloodType=" + bloodType +
                ", origin='" + origin + '\'' +
                ", age=" + age +
                ", birthdayMonth='" + birthdayMonth + '\'' +
                ", birthdayDay=" + birthdayDay +
                ", birthdayYear=" + birthdayYear +
                ", likes=" + likes +
                ", trash=" + trash +
                ", url='" + url + '\'' +
                ", husbando=" + husbando +
                ", nsfw=" + nsfw +
                ", popularityRank=" + popularityRank +
                ", likeRank=" + likeRank +
                ", trashRank=" + trashRank +
                ", appearances=" + appearances +
                ", series=" + series +
                '}';
    }

    /**
     * {@link BloodType}
     * <p>Common in Japanese culture as a potential representation of personality types</p>
     *
     */
    @Generated("jsonschema2pojo")
    public enum BloodType {

        A("A"),
        B("B"),
        O("O"),
        AB("AB");

        private final String value;
        private final static Map<String, Waifu.BloodType> CONSTANTS = new HashMap<String, Waifu.BloodType>();

        static {
            for (Waifu.BloodType bloodType: values()) {
                CONSTANTS.put(bloodType.value, bloodType);
            }
        }

        BloodType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Waifu.BloodType fromValue(String value) {
            Waifu.BloodType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }
    }
}