package me.goudham;

import java.net.http.HttpRequest;

/**
 * Represents a Result from a {@link HttpRequest} with the resulting
 * {@code statusCode} and {@code body}
 *
 * @param statusCode The status code returned by the API Response
 * @param body The body returned by the the API Response
 *
 */
record Result(Integer statusCode, String body) { }
