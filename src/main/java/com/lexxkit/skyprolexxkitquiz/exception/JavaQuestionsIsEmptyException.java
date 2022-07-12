package com.lexxkit.skyprolexxkitquiz.exception;

public class JavaQuestionsIsEmptyException extends RuntimeException {
    public JavaQuestionsIsEmptyException() {
    }

    public JavaQuestionsIsEmptyException(String message) {
        super(message);
    }

    public JavaQuestionsIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public JavaQuestionsIsEmptyException(Throwable cause) {
        super(cause);
    }
}
