package dev.canverse.expectation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberConstraintTest {

    @Test
    void greaterThan() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).greaterThan(1));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).greaterThan(2));
        assertDoesNotThrow(() -> Expect.of(2).greaterThan(1));
    }

    @Test
    void greaterThanOrEqualTo() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).greaterThanOrEq(2));
        assertDoesNotThrow(() -> Expect.of(1).greaterThanOrEq(1));
        assertDoesNotThrow(() -> Expect.of(2).greaterThanOrEq(1));
    }

    @Test
    void lessThan() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).lessThan(1));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(2).lessThan(1));
        assertDoesNotThrow(() -> Expect.of(1).lessThan(2));
    }

    @Test
    void lessThanOrEqualTo() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(2).lessThanOrEqualTo(1));
        assertDoesNotThrow(() -> Expect.of(1).lessThanOrEqualTo(1));
        assertDoesNotThrow(() -> Expect.of(1).lessThanOrEqualTo(2));
    }

    @Test
    void betweenInclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).betweenInclusive(2, 3));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(4).betweenInclusive(2, 3));
        assertDoesNotThrow(() -> Expect.of(2).betweenInclusive(2, 3));
        assertDoesNotThrow(() -> Expect.of(3).betweenInclusive(2, 3));
    }

    @Test
    void betweenExclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(2).betweenExclusive(2, 3));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(3).betweenExclusive(2, 3));
        assertDoesNotThrow(() -> Expect.of(3).betweenExclusive(2, 4));
    }

    @Test
    void notBetweenInclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(2).notBetweenInclusive(2, 3));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(3).notBetweenInclusive(2, 3));
        assertDoesNotThrow(() -> Expect.of(1).notBetweenInclusive(2, 3));
        assertDoesNotThrow(() -> Expect.of(4).notBetweenInclusive(2, 3));
    }

    @Test
    void notBetweenExclusive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(3).notBetweenExclusive(2, 4));
        assertDoesNotThrow(() -> Expect.of(1).notBetweenExclusive(2, 3));
        assertDoesNotThrow(() -> Expect.of(4).notBetweenExclusive(2, 3));
    }

    @Test
    void positive() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(-1).positive());
        assertThrows(ExpectationFailedException.class, () -> Expect.of(0).positive());
        assertDoesNotThrow(() -> Expect.of(1).positive());
    }

    @Test
    void negative() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).negative());
        assertThrows(ExpectationFailedException.class, () -> Expect.of(0).negative());
        assertDoesNotThrow(() -> Expect.of(-1).negative());
    }

    @Test
    void zero() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(1).zero());
        assertThrows(ExpectationFailedException.class, () -> Expect.of(-1).zero());
        assertDoesNotThrow(() -> Expect.of(0).zero());
    }
}