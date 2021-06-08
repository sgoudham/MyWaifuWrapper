package me.goudham;

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
}
