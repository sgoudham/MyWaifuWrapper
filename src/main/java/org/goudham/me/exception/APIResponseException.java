package org.goudham.me.exception;


import org.goudham.me.MyWaifuWrapper;

/**
 * Thrown when {@link MyWaifuWrapper} fails to return API information
 *
 */
public class APIResponseException extends Throwable {
    public APIResponseException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
