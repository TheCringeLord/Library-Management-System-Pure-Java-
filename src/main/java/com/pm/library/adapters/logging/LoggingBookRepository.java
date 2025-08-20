package com.pm.library.adapters.logging;

import com.pm.library.domain.Book;
import com.pm.library.domain.spec.BookSpecification;
import com.pm.library.ports.BookRepository;
import com.pm.library.shared.Logger;

import java.util.List;
import java.util.Optional;

public class LoggingBookRepository implements BookRepository {
    private final BookRepository delegate;

    public LoggingBookRepository(BookRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public Book save(Book entity) {
        Logger.info("Saving book id=" + entity.getId());
        return delegate.save(entity);
    }

    @Override
    public Optional<Book> findById(String id) {
        Logger.debug("findById: " + id);
        return delegate.findById(id);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        Logger.debug("findByTitle: " + title);
        return delegate.findByTitle(title);
    }

    @Override
    public List<Book> findAll() {
        Logger.debug("findAll");
        return delegate.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        Logger.info("deleteById: " + id);
        return delegate.deleteById(id);
    }

    @Override
    public List<Book> search(BookSpecification spec) {
        Logger.debug("search spec");
        return delegate.search(spec);
    }
}
