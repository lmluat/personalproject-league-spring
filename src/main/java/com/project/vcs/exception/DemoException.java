package com.project.vcs.exception;
import org.springframework.http.HttpStatus;
public class DemoException {
    private static final String PLAYER_NOT_FOUND_MSG_KEY = "TeamNotExisted";
    private static final String PLAYER_NOT_FOUND_MSG = "Team Not Found";

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }
    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
