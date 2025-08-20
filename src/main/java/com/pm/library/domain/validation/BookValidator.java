package com.pm.library.domain.validation;

import com.pm.library.services.dto.BookCreateRequest;
import com.pm.library.shared.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class BookValidator {
    private static final int TITLE_MAX = 200;
    private static final int AUTHOR_MAX = 100;

    public List<String> validateCreate(BookCreateRequest req){
        List<String> errors = new ArrayList<>();
        // Validate Empty
        if (req == null) {
            errors.add(ErrorCode.REQUEST_NULL.name());
            return errors;
        }

        String rawTitle = req.title();
        String rawAuthor = req.author();

        if (rawTitle == null || rawTitle.isBlank()) {
            errors.add(ErrorCode.TITLE_REQUIRED.name());
        } else {
            String title = rawTitle.trim();
            if (title.length() > TITLE_MAX) errors.add(ErrorCode.TITLE_LENGTH_INVALID.name());
            if (hasControlChars(title)) errors.add(ErrorCode.TITLE_CONTAINS_INVALID_CHARACTERS.name());
        }

        if (rawAuthor == null || rawAuthor.isBlank()) {
            errors.add(ErrorCode.AUTHOR_REQUIRED.name());
        } else {
            String author = rawAuthor.trim();
            if (author.length() > AUTHOR_MAX) errors.add(ErrorCode.AUTHOR_LENGTH_INVALID.name());
            if (hasControlChars(author)) errors.add(ErrorCode.AUTHOR_CONTAINS_INVALID_CHARACTERS.name());
        }

        return errors;
    }

    private static boolean hasControlChars(String s) {
        return s != null && s.chars().anyMatch(Character::isISOControl);
    }


    //TODO: Validate Update, Validate Id

}
