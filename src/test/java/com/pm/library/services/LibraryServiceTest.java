package com.pm.library.services;

import com.pm.library.adapters.repo.InMemoryBookRepository;
import com.pm.library.adapters.id.UuidGenerator;
import com.pm.library.domain.validation.BookValidator;
import com.pm.library.services.dto.BookCreateRequest;
import com.pm.library.shared.Result;
import com.pm.library.services.dto.BookView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {
    private LibraryService service;

    @BeforeEach
    void setUp() {
        var repo = new InMemoryBookRepository();
        var validator = new BookValidator();
        var idGen = new UuidGenerator();
        service = new LibraryService(repo, validator, idGen);
    }

    @Test
    void borrowAndReturn_successFlow() {
        Result<BookView> varRes = service.add(new BookCreateRequest("T", "A"));
        assertTrue(varRes.isOk());
        BookView view = varRes.getValue();

        // borrow then return
        service.borrow(view.title());
        service.returnBook(view.title());
    }

    @Test
    void borrow_alreadyBorrowed_noException() {
        Result<BookView> res = service.add(new BookCreateRequest("X", "Y"));
        assertTrue(res.isOk());
        BookView view = res.getValue();

        // First borrow
        service.borrow(view.title());
        // Second borrow should be no-op (no exception)
        service.borrow(view.title());
    }

    @Test
    void return_alreadyReturned_noException() {
        Result<BookView> res = service.add(new BookCreateRequest("R", "S"));
        assertTrue(res.isOk());
        BookView view = res.getValue();

        // Return when available should be no-op
        service.returnBook(view.title());
        // Double return
        service.returnBook(view.title());
    }
}
