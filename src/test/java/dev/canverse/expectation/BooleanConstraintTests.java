package dev.canverse.expectation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BooleanConstraintTests {

    @Test
    void isTrue() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(false).isTrue());
        assertDoesNotThrow(() -> Expect.of(true).isTrue());
    }

    @Test
    void isFalse() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(true).isFalse());
        assertDoesNotThrow(() -> Expect.of(false).isFalse());
    }
}