package com.pm.library.ui;

/**
 * Lightweight console menu skeleton. This is intentionally minimal — the app
 * console interactions live here and can be extended later.
 */
public final class ConsoleMenu {
	private final ConsoleIO io;

	public ConsoleMenu(ConsoleIO io) {
		this.io = io;
	}

	public void showMain() {
		io.println("Library Menu");
		io.println("1) Add Book");
		io.println("2) Borrow Book");
		io.println("3) Return Book");
		io.println("4) Remove Book");
		io.println("5) List Books");
		io.println("6) Search Books");
		io.println("0) Exit");
	}
}
