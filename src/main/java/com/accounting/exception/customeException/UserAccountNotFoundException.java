package com.accounting.exception.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserAccountNotFoundException extends RuntimeException {

    public UserAccountNotFoundException(String message) {
        super("User Account not found for id = " + message);
    }

    public UserAccountNotFoundException(Long message)
    {
        this(message.toString());
    }
}
