package com.pm.library.app;

import com.pm.library.services.LibraryService;
import com.pm.library.services.dto.BookCreateRequest;
import com.pm.library.shared.Result;
import com.pm.library.services.dto.BookView;

public class Main {
    public static void main(String[] args) {
        LibraryService svc = AppConfig.libraryService();

        Result<BookView> res = svc.add(new BookCreateRequest("Effective Java", "Joshua Bloch"));
        if (res.isOk()) {
            System.out.println("Added: " + res.getValue().title() + " by " + res.getValue().author());
        } else {
            System.err.println("Failed to add book: " + res.errorCode() + " - " + res.message());
        }
    }
}
