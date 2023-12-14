package dev.canverse.expectation;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalConstraintTest {

    @Test
    void absent() {
        Optional<String> optional = Optional.empty();
        assertThrows(ExpectationFailedException.class, () -> Expect.of(optional).present());
        assertDoesNotThrow(() -> Expect.of(optional).absent());
    }

    @Test
    void present() {
        Optional<String> optional = Optional.of("Hello World!");
        assertThrows(ExpectationFailedException.class, () -> Expect.of(optional).absent());
        assertDoesNotThrow(() -> Expect.of(optional).present());
    }
}