package com.project.vcs.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ ResponseException.class })
    public ResponseEntity<Object> handleAll(final ResponseException e, final WebRequest request) {
        logger.error("error", e);

        return new ResponseEntity<>(e.getResponseBody(), new HttpHeaders(), e.getResponseBody().getHttpStatus());
    }
}
