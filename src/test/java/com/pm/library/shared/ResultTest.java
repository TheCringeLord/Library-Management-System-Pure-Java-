package com.pm.library.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    void ok_isOkTrue_andValuePresent() {
        var r = Result.ok("hello");
        assertTrue(r.isOk());
        assertEquals("hello", r.getValue());
        assertNull(r.errorCode());
        assertNull(r.message());
    }
}
