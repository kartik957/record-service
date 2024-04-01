package com.nagarro.recordservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomizedException extends Exception {
    public CustomizedException(String message) {
        super(message);
    }
}