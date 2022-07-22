package com.lexxkit.skyprolexxkitquiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class CustomMethodNotAllowedException extends RuntimeException{
    public CustomMethodNotAllowedException() {
    }

    public CustomMethodNotAllowedException(String message) {
        super(message);
    }

    public CustomMethodNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomMethodNotAllowedException(Throwable cause) {
        super(cause);
    }
}
