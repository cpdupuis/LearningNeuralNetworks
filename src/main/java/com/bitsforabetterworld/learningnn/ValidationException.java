package com.bitsforabetterworld.learningnn;

public class ValidationException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -8889991163839943373L;

    public ValidationException() {
        super();
    }
    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}