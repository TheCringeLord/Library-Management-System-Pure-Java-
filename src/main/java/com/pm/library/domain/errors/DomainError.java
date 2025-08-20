package com.pm.library.domain.errors;

/**
 * Centralized domain error codes used across the application.
 * Kept as simple String constants to interoperate with existing code that
 * currently expects string error codes.
 */
public final class DomainError {
	private DomainError() {}

	public static final String REQUEST_NULL = "REQUEST_NULL";
	public static final String TITLE_REQUIRED = "TITLE_REQUIRED";
	public static final String AUTHOR_REQUIRED = "AUTHOR_REQUIRED";
	public static final String TITLE_LENGTH_INVALID = "TITLE_LENGTH_INVALID";
	public static final String AUTHOR_LENGTH_INVALID = "AUTHOR_LENGTH_INVALID";
	public static final String TITLE_CONTAINS_INVALID_CHARACTERS = "TITLE_CONTAINS_INVALID_CHARACTERS";
	public static final String AUTHOR_CONTAINS_INVALID_CHARACTERS = "AUTHOR_CONTAINS_INVALID_CHARACTERS";

	// Generic errors
	public static final String VALIDATION = "VALIDATION";
}
