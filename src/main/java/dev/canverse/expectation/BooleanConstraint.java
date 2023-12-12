package dev.canverse.expectation;


import java.util.function.Consumer;

public class BooleanConstraint extends Constraint<Boolean, BooleanConstraint> {
    protected BooleanConstraint(Boolean obj) {
        super(obj);
    }

    public BooleanConstraint isFalse() {
        if (Boolean.TRUE.equals(obj)) {
            throw new ExpectationFailedException("The value must be false.");
        }

        return this;
    }

    public BooleanConstraint isFalse(String message, Object... args) {
        if (Boolean.TRUE.equals(obj)) {
            throw new ExpectationFailedException(message, args);
        }

        return this;
    }

    public BooleanConstraint isFalse(Consumer<Boolean> errorAction) {
        if (Boolean.TRUE.equals(obj)) {
            errorAction.accept(obj);
        }

        return this;
    }

    public BooleanConstraint isTrue() {
        if (Boolean.FALSE.equals(obj)) {
            throw new ExpectationFailedException("The value must be true.");
        }

        return this;
    }

    public BooleanConstraint isTrue(String message, Object... args) {
        if (Boolean.FALSE.equals(obj)) {
            throw new ExpectationFailedException(message, args);
        }

        return this;
    }

    public BooleanConstraint isTrue(Consumer<Boolean> errorAction) {
        if (Boolean.FALSE.equals(obj)) {
            errorAction.accept(obj);
        }

        return this;
    }
}
