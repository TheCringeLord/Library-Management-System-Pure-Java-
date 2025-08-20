package com.pm.library.shared;

import java.util.Objects;

public final class Preconditions {
	private Preconditions() {}

	public static <T> T requireNonNull(T obj, String message) {
		return Objects.requireNonNull(obj, message);
	}

	public static void require(boolean condition, String message) {
		if (!condition) throw new IllegalArgumentException(message);
	}
}
