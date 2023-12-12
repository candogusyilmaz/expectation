package dev.canverse.expectation;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChronoLocalDateTimeConstraintTests {
    private final LocalDateTime now = LocalDateTime.now();
    private final LocalDateTime past = LocalDateTime.MIN.plusYears(2500);
    private final LocalDateTime maxPast = LocalDateTime.MIN;
    private final LocalDateTime future = LocalDateTime.MAX.minusYears(2500);
    private final LocalDateTime maxFuture = LocalDateTime.MAX;

    @Test
    void before() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now).before(future));
        assertDoesNotThrow(() -> Expect.of(now).before(past));
    }

    @Test
    void after() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now).after(past));
        assertDoesNotThrow(() -> Expect.of(now).after(future));
    }

    @Test
    void between() {
        assertThrows(IllegalArgumentException.class, () -> Expect.of(now).between(future, past));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now).between(future, maxFuture));
        assertDoesNotThrow(() -> Expect.of(now).between(past, future));
    }

    @Test
    void notBetween() {
        assertThrows(IllegalArgumentException.class, () -> Expect.of(now).notBetween(future, past));
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now).notBetween(past, future));
        assertDoesNotThrow(() -> Expect.of(now).notBetween(future, maxFuture));
    }

    @Test
    void past() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(future).past());
        assertDoesNotThrow(() -> Expect.of(maxPast).past());
    }

    @Test
    void future() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(past).future());
        assertDoesNotThrow(() -> Expect.of(future).future());
    }

    @Test
    void today() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(future).today());
        assertDoesNotThrow(() -> Expect.of(now).today());
    }

    @Test
    void notToday() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now).notToday());
        assertDoesNotThrow(() -> Expect.of(future).notToday());
    }

    @Test
    void leapYear() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now).leapYear());
        assertDoesNotThrow(() -> Expect.of(now.withYear(2020)).leapYear());
    }

    @Test
    void notLeapYear() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of(now.withYear(2020)).notLeapYear());
        assertDoesNotThrow(() -> Expect.of(now).notLeapYear());
    }

    @Test
    void leapDay() {
        LocalDateTime leapDay = LocalDateTime.of(2020, 2, 29, 0, 0, 0);

        assertThrows(ExpectationFailedException.class, () -> Expect.of(leapDay.minusDays(1)).leapDay());
        assertDoesNotThrow(() -> Expect.of(leapDay).leapDay());
    }

    @Test
    void notLeapDay() {
        LocalDateTime leapDay = LocalDateTime.of(2020, 2, 29, 0, 0, 0);

        assertThrows(ExpectationFailedException.class, () -> Expect.of(leapDay).notLeapDay());
        assertDoesNotThrow(() -> Expect.of(leapDay.minusDays(1)).notLeapDay());
    }
}