package com.app.myorder.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class NotFoundException extends RuntimeException {
    public static int STATUS_CODE = 404;

    @Autowired
    private static MessageSource messageSource;

    public NotFoundException(String messageKey, String[] args) {
        super(messageSource.getMessage(messageKey, args, null));
    }
}
