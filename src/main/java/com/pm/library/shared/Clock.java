package com.pm.library.shared;

import java.time.Instant;

/**
 * Lightweight clock wrapper to make time calls testable and centralised.
 */
public final class Clock {
	private Clock() {}

	public static Instant now() {
		return Instant.now();
	}

	public static long millis() {
		return System.currentTimeMillis();
	}
}
