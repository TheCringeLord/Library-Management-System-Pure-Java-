package com.pm.library.ui;

/**
 * Console IO abstraction used by the UI. Implementations may be used to
 * replace System IO in tests.
 */
public interface ConsoleIO {
	void println(String s);
	String readLine(String prompt);
}
