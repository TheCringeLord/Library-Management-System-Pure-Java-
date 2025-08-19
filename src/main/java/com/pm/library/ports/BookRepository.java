package com.pm.library.ports;

import com.pm.library.domain.Book;
import com.pm.library.domain.spec.BookSpecification;

public interface BookRepository extends
        ReadableRepository<Book, String>,
        WritableRepository<Book, String>,
        Searchable<BookSpecification, Book> {
}
