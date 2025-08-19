package com.pm.library.services.dto;

import com.pm.library.domain.Book;

public final class Mappers {
    private Mappers() {}

    public static BookView toView(Book book) {
        return new BookView(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.isAvailable()
        );
    }
}

