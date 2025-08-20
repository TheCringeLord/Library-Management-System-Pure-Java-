package com.pm.library.services.commands;

import java.util.Objects;

/**
 * Command to borrow a book by title (keeps API simple for the example app).
 */
public record BorrowBookCommand(String title) {
	public BorrowBookCommand {
		Objects.requireNonNull(title, "title");
	}
}
