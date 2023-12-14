package dev.canverse.expectation;


import java.time.LocalDateTime;
import java.time.Year;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoField;

public class ChronoLocalDateTimeConstraint<T extends ChronoLocalDateTime<?>> extends Constraint<T, ChronoLocalDateTimeConstraint<T>> {
    protected ChronoLocalDateTimeConstraint(T obj) {
        super(obj);
    }

    public ChronoLocalDateTimeConstraint<T> after(T value) {
        validateAfter(value, "The value %s must be after %s.", value, value);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> after(T value, String message, Object... args) {
        validateAfter(value, message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> before(T value) {
        validateBefore(value, "The value %s must be before %s.", value, value);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> before(T value, String message, Object... args) {
        validateBefore(value, message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> between(T start, T end) {
        validateBetween(false, start, end, "The value %s must be between %s and %s.", obj, start, end);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> between(T start, T end, String message, Object... args) {
        validateBetween(false, start, end, message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> future() {
        validateFuture("The value %s must be in the future.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> future(String message, Object... args) {
        validateFuture(message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> leapDay() {
        validateLeapDay(false, "The value %s must be a leap day.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> leapDay(String message, Object... args) {
        validateLeapDay(false, message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> leapYear() {
        validateLeapYear(false, "The value %s must be a leap year.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> notBetween(T start, T end) {
        validateBetween(true, start, end, "The value %s must not be between %s and %s.", obj, start, end);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> notBetween(T start, T end, String message, Object... args) {
        validateBetween(true, start, end, message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> notLeapDay() {
        validateLeapDay(true, "The value %s must not be a leap day.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> notLeapYear() {
        validateLeapYear(true, "The value %s must not be a leap year.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> notToday() {
        validateToday(true, "The value %s must not be today.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> notToday(String message, Object... args) {
        validateToday(true, message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> past() {
        validatePast("The value %s must be in the past.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> past(String message, Object... args) {
        validatePast(message, args);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> today() {
        validateToday(false, "The value %s must be today.", obj);
        return this;
    }

    public ChronoLocalDateTimeConstraint<T> today(String message, Object... args) {
        validateToday(false, message, args);
        return this;
    }

    private void validateAfter(T value, String message, Object... args) {
        if (obj.isAfter(value)) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateBefore(T value, String message, Object... args) {
        if (obj.isBefore(value)) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateBetween(boolean inverse, T start, T end, String message, Object... args) {
        if (start == null || end == null || message == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }

        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }

        boolean isWithinRange = (start.isBefore(obj) || start.isEqual(obj)) && (end.isAfter(obj) || end.isEqual(obj));

        if (inverse == isWithinRange) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateFuture(String message, Object... args) {
        if (obj.isBefore(LocalDateTime.now())) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateLeapDay(boolean inverse, String message, Object... args) {
        boolean isLeapDay = obj.get(ChronoField.MONTH_OF_YEAR) == 2 && obj.get(ChronoField.DAY_OF_MONTH) == 29;

        if (inverse == isLeapDay) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateLeapYear(boolean inverse, String message, Object... args) {
        int year = obj.get(ChronoField.YEAR);
        boolean isLeapYear = Year.isLeap(year);

        if (inverse == isLeapYear) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validatePast(String message, Object... args) {
        if (obj.isAfter(LocalDateTime.now())) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateToday(boolean inverse, String message, Object... args) {
        LocalDateTime now = LocalDateTime.now();
        boolean isToday = obj.get(ChronoField.YEAR) == now.getYear() && obj.get(ChronoField.DAY_OF_YEAR) == now.getDayOfYear();

        if (inverse == isToday) {
            throw new ExpectationFailedException(message, args);
        }
    }
}
