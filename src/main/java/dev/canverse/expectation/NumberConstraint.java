package dev.canverse.expectation;


@SuppressWarnings("unchecked")
public final class NumberConstraint<T extends Number & Comparable<T>> extends Constraint<T, NumberConstraint<T>> {
    NumberConstraint(T obj) {
        super(obj);
    }

    public NumberConstraint<T> betweenExclusive(T min, T max) {
        validateBetweenExclusive(false, min, max, "The value %s must be between %s and %s.", obj, min, max);
        return this;
    }

    public NumberConstraint<T> betweenInclusive(T min, T max) {
        validateBetweenInclusive(false, min, max, "The value %s must be between %s and %s.", obj, min, max);
        return this;
    }

    public NumberConstraint<T> betweenInclusive(T min, T max, String message, Object... args) {
        validateBetweenInclusive(false, min, max, message, args);
        return this;
    }

    public NumberConstraint<T> greaterThan(T value) {
        validateGreaterThan(value, "The value %s must be greater than %s.", obj, value);
        return this;
    }

    public NumberConstraint<T> greaterThan(T value, String message, Object... args) {
        validateGreaterThan(value, message, args);
        return this;
    }

    public NumberConstraint<T> greaterThanOrEq(T value) {
        validateGreaterThanOrEq(value, "The value %s must be greater than or equal to %s.", obj, value);
        return this;
    }

    public NumberConstraint<T> greaterThanOrEq(T value, String message, Object... args) {
        validateGreaterThanOrEq(value, message, args);
        return this;
    }

    public NumberConstraint<T> lessThan(T value) {
        validateLessThan(value, "The value %s must be less than %s.", obj, value);
        return this;
    }

    public NumberConstraint<T> lessThan(T value, String message, Object... args) {
        validateLessThan(value, message, args);
        return this;
    }

    public NumberConstraint<T> lessThanOrEqualTo(T value) {
        validateLessThanOrEq(value, "The value %s must be less than or equal to %s.", obj, value);
        return this;
    }

    public NumberConstraint<T> lessThanOrEqualTo(T value, String message, Object... args) {
        validateLessThanOrEq(value, message, args);
        return this;
    }

    public NumberConstraint<T> negative() {
        validateNegative("The value %s must be negative.", obj);
        return this;
    }

    public NumberConstraint<T> negative(String message, Object... args) {
        validateNegative(message, args);
        return this;
    }

    public NumberConstraint<T> notBetweenExclusive(T min, T max) {
        validateBetweenExclusive(true, min, max, "The value %s must be between %s and %s.", obj, min, max);
        return this;
    }

    public NumberConstraint<T> notBetweenInclusive(T min, T max) {
        validateBetweenInclusive(true, min, max, "The value %s must be between %s and %s.", obj, min, max);
        return this;
    }

    public NumberConstraint<T> positive() {
        validatePositive("The value %s must be positive.", obj);
        return this;
    }

    public NumberConstraint<T> positive(String message, Object... args) {
        validatePositive(message, args);
        return this;
    }

    public NumberConstraint<T> zero() {
        validateZero("The value %s must be zero.", obj);
        return this;
    }

    public NumberConstraint<T> zero(String message, Object... args) {
        validateZero(message, args);
        return this;
    }

    private void validateBetweenExclusive(boolean inverse, T min, T max, String message, Object... args) {
        boolean result = obj.compareTo(min) > 0 && obj.compareTo(max) < 0;

        if (inverse == result) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateBetweenInclusive(boolean inverse, T min, T max, String message, Object... args) {
        boolean result = obj.compareTo(min) >= 0 && obj.compareTo(max) <= 0;

        if (inverse == result) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateGreaterThan(T value, String message, Object... args) {
        if (obj.compareTo(value) <= 0) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateGreaterThanOrEq(T value, String message, Object... args) {
        if (obj.compareTo(value) < 0) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateLessThan(T value, String message, Object... args) {
        if (obj.compareTo(value) >= 0) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateLessThanOrEq(T value, String message, Object... args) {
        if (obj.compareTo(value) > 0) {
            throw new ExpectationFailedException(message, args);
        }
    }

    private void validateNegative(String message, Object... args) {
        if (obj.compareTo((T) obj.getClass().cast(0)) >= 0) {
            throw new ExpectationFailedException("The value %s must be negative.", obj);
        }
    }

    private void validatePositive(String message, Object... args) {
        if (obj.compareTo((T) obj.getClass().cast(0)) <= 0) {
            throw new ExpectationFailedException("The value %s must be positive.", obj);
        }
    }

    private void validateZero(String message, Object... args) {
        if (obj.compareTo((T) obj.getClass().cast(0)) != 0) {
            throw new ExpectationFailedException("The value %s must be zero.", obj);
        }
    }
}