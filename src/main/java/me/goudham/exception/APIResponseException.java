package me.goudham.exception;

import me.goudham.APIWrapper;

/**
 * Thrown when {@link APIWrapper} fails to return API information
 *
 */
public class APIResponseException extends Throwable {
    public APIResponseException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
