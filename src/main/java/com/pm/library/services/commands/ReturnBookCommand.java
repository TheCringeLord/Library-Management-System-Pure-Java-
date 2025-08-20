package com.pm.library.services.commands;

import java.util.Objects;

public record ReturnBookCommand(String title) {
	public ReturnBookCommand {
		Objects.requireNonNull(title, "title");
	}
}
