package com.lexxkit.skyprolexxkitquiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadAmountOfQuestionsException extends RuntimeException {
    public BadAmountOfQuestionsException() {
    }

    public BadAmountOfQuestionsException(String message) {
        super(message);
    }

    public BadAmountOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadAmountOfQuestionsException(Throwable cause) {
        super(cause);
    }
}
