package com.pm.library.services.dto;

import java.util.Objects;

public record BookCreateRequest(String title, String author) {
    public BookCreateRequest(String title, String author) {
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
    }
}
