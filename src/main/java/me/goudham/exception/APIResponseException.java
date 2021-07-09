package me.goudham.exception;

/**
 * Thrown when {@code APIWrapper} fails to return API information
 *
 */
public class APIResponseException extends Throwable {
    public APIResponseException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
