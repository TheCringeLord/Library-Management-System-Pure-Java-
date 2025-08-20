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
    private InMemoryBookRepository repo;

    @BeforeEach
    void setUp() {
    repo = new InMemoryBookRepository();
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
    var borrowRes = service.borrow(view.title());
    assertTrue(borrowRes.isOk());
    assertFalse(repo.findByTitle(view.title()).get().isAvailable());

    var returnRes = service.returnBook(view.title());
    assertTrue(returnRes.isOk());
    assertTrue(repo.findByTitle(view.title()).get().isAvailable());
    }

    @Test
    void borrow_alreadyBorrowed_noException() {
        Result<BookView> res = service.add(new BookCreateRequest("X", "Y"));
        assertTrue(res.isOk());
        BookView view = res.getValue();

    // First borrow
    var first = service.borrow(view.title());
    assertTrue(first.isOk());

    // Second borrow should return ALREADY_BORROWED
    var second = service.borrow(view.title());
    assertTrue(second.isError());
    }

    @Test
    void return_alreadyReturned_noException() {
        Result<BookView> res = service.add(new BookCreateRequest("R", "S"));
        assertTrue(res.isOk());
        BookView view = res.getValue();

    // Return when available should return ALREADY_RETURNED
    var first = service.returnBook(view.title());
    assertTrue(first.isError());
    // Make sure subsequent return still errors
    var second = service.returnBook(view.title());
    assertTrue(second.isError());
    }
}
