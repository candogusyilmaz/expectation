package dev.canverse.expectation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringConstraintTests {

    @Test
    void notNullOrEmpty() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of((String) null).notNullOrEmpty());
        assertThrows(ExpectationFailedException.class, () -> Expect.of("").notNullOrEmpty());
        assertDoesNotThrow(() -> Expect.of(" ").notNullOrEmpty());
    }

    @Test
    void equals() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").equals("b"));
        assertDoesNotThrow(() -> Expect.of("a").equals("a"));
    }

    @Test
    void notEquals() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").notEquals("a"));
        assertDoesNotThrow(() -> Expect.of("a").notEquals("b"));
    }

    @Test
    void equalsIgnoreCase() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").equalsIgnoreCase("b"));
        assertDoesNotThrow(() -> Expect.of("a").equalsIgnoreCase("A"));
    }

    @Test
    void notEqualsIgnoreCase() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").notEqualsIgnoreCase("A"));
        assertDoesNotThrow(() -> Expect.of("a").notEqualsIgnoreCase("B"));
    }

    @Test
    void contains() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").contains("b"));
        assertDoesNotThrow(() -> Expect.of("a").contains("a"));
    }

    @Test
    void notContains() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").notContains("a"));
        assertDoesNotThrow(() -> Expect.of("a").notContains("b"));
    }

    @Test
    void startsWith() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").startsWith("b"));
        assertDoesNotThrow(() -> Expect.of("a").startsWith("a"));
    }

    @Test
    void notStartsWith() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").notStartsWith("a"));
        assertDoesNotThrow(() -> Expect.of("a").notStartsWith("b"));
    }

    @Test
    void endsWith() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").endsWith("b"));
        assertDoesNotThrow(() -> Expect.of("a").endsWith("a"));
    }

    @Test
    void notEndsWith() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").notEndsWith("a"));
        assertDoesNotThrow(() -> Expect.of("a").notEndsWith("b"));
    }

    @Test
    void length() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").length(2));
        assertDoesNotThrow(() -> Expect.of("a").length(1));
    }

    @Test
    void lengthGt() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthGt(1));
        assertDoesNotThrow(() -> Expect.of("a").lengthGt(0));
    }

    @Test
    void lengthGte() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthGte(2));
        assertDoesNotThrow(() -> Expect.of("a").lengthGte(1));
    }

    @Test
    void lengthLt() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthLt(1));
        assertDoesNotThrow(() -> Expect.of("a").lengthLt(2));
    }

    @Test
    void lengthLte() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthLte(0));
        assertDoesNotThrow(() -> Expect.of("a").lengthLte(1));
    }

    @Test
    void lengthBetweenInclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthBetweenInclusive(0, 0));
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthBetweenInclusive(2, 2));
        assertDoesNotThrow(() -> Expect.of("a").lengthBetweenInclusive(1, 1));
    }

    @Test
    void lengthBetweenExclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthBetweenExclusive(1, 1));
        assertDoesNotThrow(() -> Expect.of("a").lengthBetweenExclusive(0, 2));
    }

    @Test
    void lengthNotBetweenInclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthNotBetweenInclusive(1, 1));
        assertDoesNotThrow(() -> Expect.of("a").lengthNotBetweenInclusive(0, 0));
        assertDoesNotThrow(() -> Expect.of("a").lengthNotBetweenInclusive(2, 2));
    }

    @Test
    void lengthNotBetweenExclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").lengthNotBetweenExclusive(0, 2));
        assertDoesNotThrow(() -> Expect.of("a").lengthNotBetweenExclusive(1, 2));
    }

    @Test
    void numeric() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").numeric());
        assertDoesNotThrow(() -> Expect.of("1").numeric());
    }

    @Test
    void alphanumeric() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a!").alphanumeric());
        assertDoesNotThrow(() -> Expect.of("a1").alphanumeric());
    }

    @Test
    void lowercase() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("A").lowercase());
        assertDoesNotThrow(() -> Expect.of("a").lowercase());
    }

    @Test
    void uppercase() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of("a").uppercase());
        assertDoesNotThrow(() -> Expect.of("A").uppercase());
    }
}