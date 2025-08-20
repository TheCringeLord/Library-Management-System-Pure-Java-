package com.pm.library.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Minimal console IO abstraction to keep system IO in one place for testing.
 */
public final class ConsoleIO {
	private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public void println(String s) {
		System.out.println(s);
	}

	public String readLine(String prompt) {
		try {
			System.out.print(prompt);
			return in.readLine();
		} catch (IOException e) {
			return null;
		}
	}
}
