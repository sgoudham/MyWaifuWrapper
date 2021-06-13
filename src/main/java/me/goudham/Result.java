package me.goudham;

import java.net.http.HttpRequest;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(statusCode, result.statusCode) && Objects.equals(body, result.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body);
    }

    @Override
    public String toString() {
        return "Result{" +
                "statusCode=" + statusCode +
                ", body='" + body + '\'' +
                '}';
    }
}
