package com.pm.library.domain;

import com.pm.library.domain.errors.DomainError;

import java.util.Objects;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean available;

    public Book(String id, String title, String author, boolean available) {
        this.id = Objects.requireNonNull(id, "Book ID cannot be null");
        this.title = Objects.requireNonNull(title, "Book Title cannot be null");
        this.author = Objects.requireNonNull(author, "Book Author cannot be null");
        this.available = available;
    }
    //Getters

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }

    public void borrow(){
        if(available) {
            this.available = false;
        } else {
            throw new IllegalStateException("Book already borrowed");
        }
    }

    public void returnBook(){
        if(!available) {
            this.available = true;
        } else  {
            throw new IllegalStateException("Book already returned");
        }
    }

}
