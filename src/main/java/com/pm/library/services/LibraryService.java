package com.pm.library.services;

import com.pm.library.domain.Book;
import com.pm.library.domain.validation.BookValidator;
import com.pm.library.ports.BookRepository;
import com.pm.library.ports.IdGenerator;
import com.pm.library.services.dto.BookCreateRequest;
import com.pm.library.services.dto.BookView;
import com.pm.library.services.dto.Mappers;
import com.pm.library.shared.Result;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.String.join;

public class LibraryService {
    private final BookRepository repo;
    private final IdGenerator idGen;
    private  final BookValidator validator;

    // similar example (not your exact class):
    public LibraryService(BookRepository repo, BookValidator validator, IdGenerator idGen) {
        this.repo = Objects.requireNonNull(repo, "repo is required");
        this.validator = Objects.requireNonNull(validator, "validator is required");
        this.idGen = Objects.requireNonNull(idGen, "idGen is required");
    }

    public Result<BookView> add(BookCreateRequest req) {
        List<String> errors = validator.validateCreate(req);
        if (!errors.isEmpty()) {
            return Result.error("VALIDATION", String.join(";", errors));
        }

        String id = idGen.newId();
        Book book = new Book(id, req.title().trim(), req.author().trim(), true);
        repo.save(book);

        return Result.ok(Mappers.toView(book));
    }

    public void borrow(String title) {
       Optional<Book> bookOpt = repo.findByTitle(title);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            try {
                book.borrow();
                repo.save(book);
            } catch (IllegalStateException ex) {
                // already borrowed - no-op for now, could return a Result in future
            }
        } else {
            // not found - no-op for now
        }
    }



}
