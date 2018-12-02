package com.weteam.musicplayapi;

public class CommonException extends RuntimeException {

    private String message;

    public CommonException() {}

    public CommonException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
