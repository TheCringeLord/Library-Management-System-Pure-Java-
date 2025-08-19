package com.pm.library.domain.validation;

import com.pm.library.services.dto.BookCreateRequest;

import java.util.ArrayList;
import java.util.List;

public class BookValidator {
    private static final int TITLE_MAX = 200;
    private static final int AUTHOR_MAX = 100;

    public List<String> validateCreate(BookCreateRequest req){
        List<String> errors = new ArrayList<>();
        String rawTitle = req.title();
        String rawAuthor = req.author();

        //Validate Empty
        if (req == null) {
            errors.add("REQUEST_NULL");
            return errors;
        }

        if (rawTitle == null || rawTitle.isBlank()) {
            errors.add("TITLE_REQUIRED");
        } else {
            String title = rawTitle.trim();
            if (title.length() > TITLE_MAX) errors.add("TITLE_LENGTH_INVALID");
            if (hasControlChars(title)) errors.add("TITLE_CONTAINS_INVALID_CHARACTERS");
        }

        if (rawAuthor == null || rawAuthor.isBlank()) {
            errors.add("AUTHOR_REQUIRED");
        } else {
            String author = rawAuthor.trim();
            if (author.length() > AUTHOR_MAX) errors.add("AUTHOR_LENGTH_INVALID");
            if (hasControlChars(author)) errors.add("AUTHOR_CONTAINS_INVALID_CHARACTERS");
        }

        return errors;
    }

    private static boolean hasControlChars(String s) {
        return s != null && s.chars().anyMatch(Character::isISOControl);
    }


    //TODO: Validate Update, Validate Id

}
