package me.goudham;

import java.net.http.HttpRequest;

/**
 * Represents a Result from a {@link HttpRequest} with the resulting
 * {@code statusCode} and {@code body}
 */
class Result {
    private final Integer statusCode;
    private final String body;

    Result(Integer statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    Integer getStatusCode() {
        return statusCode;
    }

    String getBody() {
        return body;
    }
}
