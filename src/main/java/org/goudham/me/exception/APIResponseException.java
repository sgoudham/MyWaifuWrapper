package org.goudham.me.exception;

import org.goudham.me.APIWrapper;

/**
 * Thrown when {@link APIWrapper} fails to return API information
 *
 */
public class APIResponseException extends Throwable {
    public APIResponseException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
