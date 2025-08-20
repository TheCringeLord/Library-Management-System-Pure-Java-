package com.pm.library.services.commands;

import java.util.Objects;

/**
 * Simple command object used to request adding a book.
 */
public record AddBookCommand(String title, String author) {
	public AddBookCommand {
		Objects.requireNonNull(title, "title");
		Objects.requireNonNull(author, "author");
	}
}
