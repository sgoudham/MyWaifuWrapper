package org.goudham.me;

public class Response<T> {
    private T entity;
    private final Integer responseCode;
    private final String responseBody;

    Response(Integer responseCode, String responseBody, T entity) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.entity = entity;
    }

    Response(Integer responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public T getEntity() {
        return entity;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
