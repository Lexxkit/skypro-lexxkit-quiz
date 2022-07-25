package com.lexxkit.skyprolexxkitquiz.exception;

public class MathQuestionsIsEmptyException extends RuntimeException {
    public MathQuestionsIsEmptyException() {
    }

    public MathQuestionsIsEmptyException(String message) {
        super(message);
    }

    public MathQuestionsIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathQuestionsIsEmptyException(Throwable cause) {
        super(cause);
    }
}
