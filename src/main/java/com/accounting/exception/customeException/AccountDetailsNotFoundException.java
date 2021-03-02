package com.accounting.exception.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountDetailsNotFoundException extends RuntimeException {

    public AccountDetailsNotFoundException(String message) {
        super("Account not found for id = " + message);
    }

    public AccountDetailsNotFoundException(Long message)
    {
        this(message.toString());
    }
}
