package com.pm.library.services.dto;

import java.util.Objects;

public class BookCreateRequest {
    private final String title;
    private final String author;

    public BookCreateRequest(String title, String author) {
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}
