package com.present3.rest_client_webcient_http_interface.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class MyCustomRuntimeException extends RuntimeException {
    private final HttpStatusCode statusCode;
    private final HttpHeaders headers;

    public MyCustomRuntimeException(HttpStatusCode statusCode, HttpHeaders headers) {
        super("HTTP Error: " + statusCode + " Headers: " + headers);
        this.statusCode = statusCode;
        this.headers = headers;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }
}
