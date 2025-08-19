package com.pm.library.domain.validation;

import com.pm.library.services.dto.BookCreateRequest;

import java.util.ArrayList;
import java.util.List;

public class BookValidator {

    public List<String> validateCreate(BookCreateRequest req){
        List<String> errors = new ArrayList<>();
        String title = req.getTitle().trim();
        String author = req.getAuthor().trim();
        int TITLE_MAX = 200;
        int AUTHOR_MAX = 100;

        //Validate Empty
        if (title.isEmpty()) {
            errors.add("TITLE_REQUIRED");
        }
        if(author.isBlank()){
           errors.add("AUTHOR_REQUIRED");
        }

        //Validate Length

        if(title.length() > TITLE_MAX){
            errors.add("TITLE_TOO_LONG");
        }
        if(author.length() > AUTHOR_MAX){
            errors.add("AUTHOR_TOO_LONG");
        }

        //Validate Valid Character
        if(hasControlChars(title)){
            errors.add("TITLE_INVALID");
        }
        if(hasControlChars(author)){
            errors.add("AUTHOR_INVALID");
        }

        return errors;
    }
    boolean hasControlChars(String s) {
        return s != null && s.chars().anyMatch(Character::isISOControl);
    }

    //TODO: Validate Update, Validate Id

}
