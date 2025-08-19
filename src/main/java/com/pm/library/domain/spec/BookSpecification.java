package com.pm.library.domain.spec;


import com.pm.library.domain.Book;

public interface BookSpecification {
    boolean isSatisfiedBy(Book book);
}
