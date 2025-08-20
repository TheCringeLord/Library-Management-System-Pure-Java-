package com.pm.library.shared;

import java.time.Instant;

public final class Logger {
	private Logger() {}

	public static void info(String msg) {
		System.out.println(Instant.now() + " [INFO] " + msg);
	}

	public static void debug(String msg) {
		System.out.println(Instant.now() + " [DEBUG] " + msg);
	}

	public static void error(String msg) {
		System.err.println(Instant.now() + " [ERROR] " + msg);
	}
}
