package com.pm.library.services.dto;

import java.util.Objects;

public record BookView(String id, String title, String author, boolean available) {
    public   BookView(String id, String title, String author, boolean available) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.available = available;
    }
}
