package me.goudham.util;

/**
 * Listing all 4 {@link Season}'s
 *
 */
public enum Season {
    SPRING("spring"),
    SUMMER("summer"),
    FALL("fall"),
    WINTER("winter");

    private final String season;

    Season(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }
}
