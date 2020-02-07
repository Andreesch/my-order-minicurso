package com.app.myorder.exceptions;

public class NotFoundException extends RuntimeException  {
    public static int STATUS_CODE = 404;

    public NotFoundException(String message) {
        super(message);
    }
}
