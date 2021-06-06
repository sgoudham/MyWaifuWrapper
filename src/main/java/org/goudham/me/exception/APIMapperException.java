package org.goudham.me.exception;


import org.goudham.me.MyWaifuWrapper;
import org.goudham.me.Response;

/**
 * Thrown when {@link MyWaifuWrapper} fails to unmarshal json into Java POJO's ({@link Response#getEntity()})
 *
 */
public class APIMapperException extends Throwable {
    public APIMapperException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
