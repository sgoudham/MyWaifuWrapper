package me.goudham.util;

import me.goudham.domain.user.User;
import me.goudham.domain.waifu.Waifu;

/**
 * Specifies the different actions that the {@link User} can
 * perform on a {@link Waifu}
 *
 */
public enum WaifuListType {
    CREATED("created"),
    LIKED("like"),
    TRASHED("trash");

    private final String listType;

    WaifuListType(String listType) {
        this.listType = listType;
    }

    public String getListType() {
        return listType;
    }
}
