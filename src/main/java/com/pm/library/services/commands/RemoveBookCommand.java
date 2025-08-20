package com.pm.library.services.commands;

import java.util.Objects;

public record RemoveBookCommand(String id) {
	public RemoveBookCommand {
		Objects.requireNonNull(id, "id");
	}
}
