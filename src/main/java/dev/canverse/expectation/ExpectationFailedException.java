package dev.canverse.expectation;

public class ExpectationFailedException extends RuntimeException {
    public ExpectationFailedException(String message, Object... args) {
        this(String.format(message, args));
    }

    public ExpectationFailedException(String message) {
        super(message);
    }
}
