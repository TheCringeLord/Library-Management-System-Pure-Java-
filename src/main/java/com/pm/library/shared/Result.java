package com.pm.library.shared;

import java.util.Objects;

public final class Result<T> {
    private final T value;
    private final ErrorCode errorCode;
    private final String message;

    private Result(T value, ErrorCode errorCode, String message) {
        this.value = value;
        this.errorCode = errorCode;
        this.message = message;
    }

    // Factory methods
    public static <T> Result<T> ok(T value) {
        return new Result<>(Objects.requireNonNull(value), null, null);
    }

    public static <T> Result<T> error(ErrorCode code, String msg) {
        return new Result<>(null, Objects.requireNonNull(code), msg);
    }

    // Query methods
    public boolean isOk() {
        return errorCode == null;
    }

    public T getValue() {
        if (!isOk()) throw new IllegalStateException("Result is error: " + errorCode + " - " + message);
        return value;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public String message() {
        return message;
    }

    public boolean isError() {
        return !isOk();
    }

}

