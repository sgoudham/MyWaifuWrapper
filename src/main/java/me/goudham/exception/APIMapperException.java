package me.goudham.exception;

import me.goudham.APIWrapper;
import me.goudham.Response;

/**
 * Thrown when {@link APIWrapper} fails to deserialize json into Java POJO's ({@link Response#getEntity()})
 *
 */
public class APIMapperException extends Throwable {
    public APIMapperException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
