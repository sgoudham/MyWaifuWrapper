package me.goudham.domain.waifu;

import com.fasterxml.jackson.annotation.*;
import me.goudham.domain.series.Series;
import me.goudham.domain.user.Creator;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * {@link Waifu}
 * <p>Contains most common attributes for {@link Waifu}'s based on various source material</p>
 *
 * <p> Fields included are: </p>
 * <ul>
 *  <li>{@link Integer id}</li>
 *  <li>{@link String slug}</li>
 *  <li>{@link Creator creator}</li>
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
public record Waifu(
        Integer id,
        String slug,
        Creator creator,
        String name,
        @JsonProperty("original_name") String originalName,
        @JsonProperty("romaji_name") String romajiName,
        @JsonProperty("display_picture") String displayPicture,
        String description,
        Double weight,
        Double height,
        Double bust,
        Double hip,
        Double waist,
        @JsonProperty("blood_type") Waifu.BloodType bloodType,
        String origin,
        Integer age,
        @JsonProperty("birthday_month") String birthdayMonth,
        @JsonProperty("birthday_day") Integer birthdayDay,
        @JsonProperty("birthday_year") String birthdayYear,
        Integer likes,
        Integer trash,
        String url,
        Boolean husbando,
        Boolean nsfw,
        @JsonProperty("popularity_rank") String popularityRank,
        @JsonProperty("like_rank") Integer likeRank,
        @JsonProperty("trash_rank") String trashRank,
        List<Series> appearances,
        Series series
) {

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