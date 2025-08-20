package com.pm.library.domain.validation;

import com.pm.library.services.dto.BookCreateRequest;
import org.junit.jupiter.api.Test;

import java.util.List;

import com.pm.library.shared.ErrorCode;

import static org.junit.jupiter.api.Assertions.*;

public class BookValidatorTest {

    @Test
    void validateCreate_nullRequest_returnsRequestNull() {
        BookValidator validator = new BookValidator();
        List<String> errors = validator.validateCreate(null);

        assertNotNull(errors, "errors list should not be null");
        assertEquals(1, errors.size(), "expected exactly one error for a null request");
    assertEquals(ErrorCode.REQUEST_NULL.name(), errors.get(0));
    }

    @Test
    void validateCreate_blankTitle_returnsTitleRequired(){
        BookValidator validator = new BookValidator();
        List<String> errors = validator.validateCreate(new BookCreateRequest("", "Author"));
        assertNotNull(errors, "errors list should not be null");
        assertEquals(1, errors.size(), "expected exactly one error for a null request");
    assertEquals(ErrorCode.TITLE_REQUIRED.name(), errors.getFirst());
    }

    @Test
    void validateCreate_blankAuthor_returnsAuthorRequired(){
        BookValidator validator = new BookValidator();
        List<String> errors = validator.validateCreate(new BookCreateRequest("Title", ""));
        assertNotNull(errors, "errors list should not be null");
        assertEquals(1, errors.size(), "expected exactly one error for a null request");
    assertEquals(ErrorCode.AUTHOR_REQUIRED.name(), errors.getFirst());
    }

    @Test
    void validateCreate_titleTooLong_returnsTitleLengthInvalid() {
        BookValidator validator = new BookValidator();
        String longString = "Title Too Long ".repeat(200); 

        List<String> errors = validator.validateCreate(new BookCreateRequest(longString, "Author"));

        assertNotNull(errors, "errors list should not be null");
        assertEquals(1, errors.size(), "expected exactly one error for a too-long title");
    assertEquals(ErrorCode.TITLE_LENGTH_INVALID.name(), errors.getFirst());
    }

    @Test
    void validateCreate_authorTooLong_returnsAuthorLengthInvalid(){
        BookValidator validator = new BookValidator();
        String longString = "Author Too Long ".repeat(100); 

        List<String> errors = validator.validateCreate(new BookCreateRequest("Title", longString));

        assertNotNull(errors, "errors list should not be null");
        assertEquals(1, errors.size(), "expected exactly one error for a too-long author");
    assertEquals(ErrorCode.AUTHOR_LENGTH_INVALID.name(), errors.getFirst());
    }

    @Test
    void validateCreate_titleWithControlChars_returnsInvalidCharacters() {
        BookValidator validator = new BookValidator();

        String badTitle = "GoodTitle\nBadPart";

        List<String> errors = validator.validateCreate(new BookCreateRequest(badTitle, "Author"));

        assertNotNull(errors, "errors list should not be null");
        assertEquals(1, errors.size(), "expected exactly one error for invalid characters");
    assertEquals(ErrorCode.TITLE_CONTAINS_INVALID_CHARACTERS.name(), errors.get(0));
    }

    @Test
    void validateCreate_validInputs_returnsNoErrors() {
        BookValidator validator = new BookValidator();

        List<String> errors = validator.validateCreate(new BookCreateRequest("Clean Title", "Good Author"));

        assertNotNull(errors, "errors list should not be null");
        assertTrue(errors.isEmpty(), "expected no errors for valid inputs");
    }

    @Test
    void validateCreate_blankTitleAndAuthor_returnsBothErrors() {
        BookValidator validator = new BookValidator();
        List<String> errors = validator.validateCreate(new BookCreateRequest("", ""));

        assertNotNull(errors);
        assertEquals(2, errors.size(), "expected two errors for blank title and author");
    assertTrue(errors.contains(ErrorCode.TITLE_REQUIRED.name()));
    assertTrue(errors.contains(ErrorCode.AUTHOR_REQUIRED.name()));
    }

    @Test
    void validateCreate_authorWithControlChars_returnsInvalidCharacters() {
        BookValidator validator = new BookValidator();
        String badAuthor = "GoodAuthor\nBadPart";

        List<String> errors = validator.validateCreate(new BookCreateRequest("Title", badAuthor));

        assertNotNull(errors);
        assertEquals(1, errors.size());
    assertEquals(ErrorCode.AUTHOR_CONTAINS_INVALID_CHARACTERS.name(), errors.getFirst());
    }

    @Test
    void validateCreate_titleAndAuthorTooLong_returnsBothLengthErrors() {
        BookValidator validator = new BookValidator();
        String longTitle = "T".repeat(201);
        String longAuthor = "A".repeat(101);

        List<String> errors = validator.validateCreate(new BookCreateRequest(longTitle, longAuthor));

        assertNotNull(errors);
        assertEquals(2, errors.size());
    assertTrue(errors.contains(ErrorCode.TITLE_LENGTH_INVALID.name()));
    assertTrue(errors.contains(ErrorCode.AUTHOR_LENGTH_INVALID.name()));
    }

}
