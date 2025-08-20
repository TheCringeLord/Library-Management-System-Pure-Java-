package com.pm.library.domain.errors;

import com.pm.library.shared.ErrorCode;

/**
 * Backwards-compatible shim mapping old string constants to the new
 * {@link ErrorCode} enum. New code should use {@link ErrorCode} directly.
 */
public final class DomainError {
	private DomainError() {}

	public static final String REQUEST_NULL = ErrorCode.REQUEST_NULL.name();
	public static final String TITLE_REQUIRED = ErrorCode.TITLE_REQUIRED.name();
	public static final String AUTHOR_REQUIRED = ErrorCode.AUTHOR_REQUIRED.name();
	public static final String TITLE_LENGTH_INVALID = ErrorCode.TITLE_LENGTH_INVALID.name();
	public static final String AUTHOR_LENGTH_INVALID = ErrorCode.AUTHOR_LENGTH_INVALID.name();
	public static final String TITLE_CONTAINS_INVALID_CHARACTERS = ErrorCode.TITLE_CONTAINS_INVALID_CHARACTERS.name();
	public static final String AUTHOR_CONTAINS_INVALID_CHARACTERS = ErrorCode.AUTHOR_CONTAINS_INVALID_CHARACTERS.name();

	// Generic errors
	public static final String VALIDATION = ErrorCode.VALIDATION.name();
	public static final String NOT_FOUND = ErrorCode.NOT_FOUND.name();
	public static final String ALREADY_BORROWED = ErrorCode.ALREADY_BORROWED.name();
	public static final String ALREADY_RETURNED = ErrorCode.ALREADY_RETURNED.name();
}
