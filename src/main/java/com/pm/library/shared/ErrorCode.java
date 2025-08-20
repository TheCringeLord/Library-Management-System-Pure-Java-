package com.pm.library.shared;

/**
 * Typed error codes used across the application (preferred over raw strings).
 */
public enum ErrorCode {
    // Validation / request level
    REQUEST_NULL,
    TITLE_REQUIRED,
    AUTHOR_REQUIRED,
    TITLE_LENGTH_INVALID,
    AUTHOR_LENGTH_INVALID,
    TITLE_CONTAINS_INVALID_CHARACTERS,
    AUTHOR_CONTAINS_INVALID_CHARACTERS,

    // Generic / service level
    VALIDATION,
    NOT_FOUND,
    ALREADY_BORROWED,
    ALREADY_RETURNED,
    UNKNOWN
}
