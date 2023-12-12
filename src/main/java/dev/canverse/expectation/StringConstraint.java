package dev.canverse.expectation;

public final class StringConstraint extends Constraint<String, StringConstraint> {

    StringConstraint(String obj) {
        super(obj);
    }

    public StringConstraint notNullOrEmpty() {
        validateNotNullOrEmpty(obj, "The value must not be null or empty.");
        return this;
    }

    private void validateNotNullOrEmpty(String value, String message, Object... args) {
        if (obj == null || obj.isEmpty()) {
            throw new ExpectationFailedException("The value must not be null or empty.");
        }
    }

    public StringConstraint notNullOrEmpty(String message, Object... args) {
        validateNotNullOrEmpty(obj, message, args);
        return this;
    }

    public StringConstraint equals(String value) {
        validateEquals(false, false, value, "The value %s must be equal to %s.", obj, value);
        return this;
    }

    private void validateEquals(boolean inverse, boolean ignoreCase, String value, String message, Object... args) {
        boolean result = ignoreCase ? obj.equalsIgnoreCase(value) : obj.equals(value);

        if (inverse == result) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint equals(String value, String message, Object... args) {
        validateEquals(false, false, value, message, args);
        return this;
    }

    public StringConstraint notEquals(String value) {
        validateEquals(true, false, value, "The value %s must not be equal to %s.", obj, value);
        return this;
    }

    public StringConstraint notEquals(String value, String message, Object... args) {
        validateEquals(true, false, value, message, args);
        return this;
    }

    public StringConstraint equalsIgnoreCase(String value) {
        validateEquals(false, true, value, "The value %s must be equal to %s.", obj, value);
        return this;
    }

    public StringConstraint equalsIgnoreCase(String value, String message, Object... args) {
        validateEquals(false, true, value, message, args);
        return this;
    }

    public StringConstraint notEqualsIgnoreCase(String value) {
        validateEquals(true, true, value, "The value %s must not be equal to %s.", obj, value);
        return this;
    }

    public StringConstraint notEqualsIgnoreCase(String value, String message, Object... args) {
        validateEquals(true, true, value, message, args);
        return this;
    }

    public StringConstraint contains(String value) {
        validateContains(false, value, "The value %s must contain %s.", obj, value);
        return this;
    }

    private void validateContains(boolean inverse, String value, String message, Object... args) {
        boolean result = obj.contains(value);

        if (inverse == result) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint notContains(String value) {
        validateContains(true, value, "The value %s must not contain %s.", obj, value);
        return this;
    }

    public StringConstraint startsWith(String value) {
        validateStartsWith(false, value, "The value %s must start with %s.", obj, value);
        return this;
    }

    private void validateStartsWith(boolean inverse, String value, String message, Object... args) {
        boolean result = obj.startsWith(value);

        if (inverse == result) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint startsWith(String value, String message, Object... args) {
        validateStartsWith(false, value, message, args);
        return this;
    }

    public StringConstraint notStartsWith(String value) {
        validateStartsWith(true, value, "The value %s must not start with %s.", obj, value);
        return this;
    }

    public StringConstraint notStartsWith(String value, String message, Object... args) {
        validateStartsWith(true, value, message, args);
        return this;
    }

    public StringConstraint endsWith(String value) {
        validateEndsWith(false, value, "The value %s must end with %s.", obj, value);
        return this;
    }

    private void validateEndsWith(boolean inverse, String value, String message, Object... args) {
        boolean result = obj.endsWith(value);

        if (inverse == result) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint endsWith(String value, String message, Object... args) {
        validateEndsWith(false, value, message, args);
        return this;
    }

    public StringConstraint notEndsWith(String value) {
        validateEndsWith(true, value, "The value %s must not end with %s.", obj, value);
        return this;
    }

    public StringConstraint notEndsWith(String value, String message, Object... args) {
        validateEndsWith(true, value, message, args);
        return this;
    }

    public StringConstraint length(int length) {
        validateLength(length, "The value %s must have length %s.", obj, length);
        return this;
    }

    private void validateLength(int length, String message, Object... args) {
        if (obj.length() != length) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint length(int length, String message, Object... args) {
        validateLength(length, message, args);
        return this;
    }

    public StringConstraint lengthGt(int length) {
        validateLengthGt(length, "The value %s must have length greater than %s.", obj, length);
        return this;
    }

    private void validateLengthGt(int length, String message, Object... args) {
        if (obj.length() <= length) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lengthGt(int length, String message, Object... args) {
        validateLengthGt(length, message, args);
        return this;
    }

    public StringConstraint lengthGte(int length) {
        validateLengthGte(length, "The value %s must have length greater than or equal to %s.", obj, length);
        return this;
    }

    private void validateLengthGte(int length, String message, Object... args) {
        if (obj.length() < length) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lengthGte(int length, String message, Object... args) {
        validateLengthGte(length, message, args);
        return this;
    }

    public StringConstraint lengthLt(int length) {
        validateLengthLt(length, "The value %s must have length less than %s.", obj, length);
        return this;
    }

    private void validateLengthLt(int length, String message, Object... args) {
        if (obj.length() >= length) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lengthLt(int length, String message, Object... args) {
        validateLengthLt(length, message, args);
        return this;
    }

    public StringConstraint lengthLte(int length) {
        validateLengthLte(length, "The value %s must have length less than or equal to %s.", obj, length);
        return this;
    }

    private void validateLengthLte(int length, String message, Object... args) {
        if (obj.length() > length) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lengthLte(int length, String message, Object... args) {
        validateLengthLte(length, message, args);
        return this;
    }

    public StringConstraint lengthBetweenInclusive(int min, int max) {
        validateLengthBetweenInclusive(false, min, max, "The value %s must have length between %s and %s.", obj, min, max);
        return this;
    }

    private void validateLengthBetweenInclusive(boolean inverse, int min, int max, String message, Object... args) {
        if (inverse == !(obj.length() < min || obj.length() > max)) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lengthBetweenInclusive(int min, int max, String message, Object... args) {
        validateLengthBetweenInclusive(false, min, max, message, args);
        return this;
    }

    public StringConstraint lengthBetweenExclusive(int min, int max) {
        validateLengthBetweenExclusive(false, min, max, "The value %s must have length between %s and %s.", obj, min, max);
        return this;
    }

    private void validateLengthBetweenExclusive(boolean inverse, int min, int max, String message, Object... args) {
        if (inverse == !(obj.length() <= min || obj.length() >= max)) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lengthBetweenExclusive(int min, int max, String message, Object... args) {
        validateLengthBetweenExclusive(false, min, max, message, args);
        return this;
    }

    public StringConstraint lengthNotBetweenInclusive(int min, int max) {
        validateLengthBetweenInclusive(true, min, max, "The value %s must not have length between %s and %s.", obj, min, max);
        return this;
    }

    public StringConstraint lengthNotBetweenInclusive(int min, int max, String message, Object... args) {
        validateLengthBetweenInclusive(true, min, max, message, args);
        return this;
    }

    public StringConstraint lengthNotBetweenExclusive(int min, int max) {
        validateLengthBetweenExclusive(true, min, max, "The value %s must not have length between %s and %s.", obj, min, max);
        return this;
    }

    public StringConstraint lengthNotBetweenExclusive(int min, int max, String message, Object... args) {
        validateLengthBetweenExclusive(true, min, max, message, args);
        return this;
    }

    public StringConstraint numeric() {
        validateNumeric("The value %s must be numeric.", obj);
        return this;
    }

    private void validateNumeric(String message, Object... args) {
        if (!obj.matches("^[0-9]*$")) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint numeric(String message, Object... args) {
        validateNumeric(message, args);
        return this;
    }

    public StringConstraint alphanumeric() {
        validateAlphanumeric("The value %s must be alphanumeric.", obj);
        return this;
    }

    private void validateAlphanumeric(String message, Object... args) {
        if (!obj.matches("^[a-zA-Z0-9]*$")) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint alphanumeric(String message, Object... args) {
        validateAlphanumeric(message, args);
        return this;
    }

    public StringConstraint lowercase() {
        validateLowercase("The value %s must be lowercase.", obj);
        return this;
    }

    private void validateLowercase(String message, Object... args) {
        if (!obj.matches("^[a-z]*$")) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint lowercase(String message, Object... args) {
        validateLowercase(message, args);
        return this;
    }

    public StringConstraint uppercase() {
        validateUppercase("The value %s must be uppercase.", obj);
        return this;
    }

    private void validateUppercase(String message, Object... args) {
        if (!obj.matches("^[A-Z]*$")) {
            throw new ExpectationFailedException(message, args);
        }
    }

    public StringConstraint uppercase(String message, Object... args) {
        validateUppercase(message, args);
        return this;
    }
}
