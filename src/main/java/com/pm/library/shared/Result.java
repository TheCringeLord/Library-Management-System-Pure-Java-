package com.pm.library.shared;

public final class Result<T> {
    private final T value;
    private final String errorCode;
    private final String message;

    private Result(T value, String errorCode, String message) {
        this.value = value;
        this.errorCode = errorCode;
        this.message = message;
    }

    // Factory methods
    public static <T> Result<T> ok(T value) {
        return new Result<>(value, null, null);
    }
    public static <T> Result<T> error(String code, String msg) {
        return new Result<>(null, code, msg);
    }

    // Query methods
    public boolean isOk() {
        return errorCode == null;
    }

    public T getValue() {
        if (!isOk()) throw new IllegalStateException("Result is error: " + errorCode + " - " + message);
        return value;
    }

    public String errorCode() {
        return errorCode;
    }

    public String message() {
        return message;
    }

    public boolean isError() {
        return !isOk();
    }

}

