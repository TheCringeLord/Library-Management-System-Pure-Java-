package com.pm.library.app;

import com.pm.library.adapters.logging.LoggingBookRepository;
import com.pm.library.adapters.repo.InMemoryBookRepository;
import com.pm.library.domain.validation.BookValidator;
import com.pm.library.ports.BookRepository;
import com.pm.library.adapters.id.UuidGenerator;
import com.pm.library.ports.IdGenerator;
import com.pm.library.services.LibraryService;

public final class AppConfig {
	private AppConfig() {}

	public static LibraryService libraryService() {
		InMemoryBookRepository repo = new InMemoryBookRepository();
		BookRepository loggingRepo = new LoggingBookRepository(repo);
		BookValidator validator = new BookValidator();
		IdGenerator idGen = new UuidGenerator();

		return new LibraryService(loggingRepo, validator, idGen);
	}
}
