package me.goudham.exception;

import me.goudham.Response;

/**
 * Thrown when {@code APIWrapper} fails to deserialize json into Java POJO's ({@link Response#getModel()})
 *
 */
public class APIMapperException extends Throwable {
    public APIMapperException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
