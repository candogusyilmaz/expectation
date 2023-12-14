package dev.canverse.expectation;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalConstraint<T> extends Constraint<Optional<T>, OptionalConstraint<T>> {
    protected OptionalConstraint(Optional<T> value) {
        super(value);
    }

    /**
     * Validates that the optional value is absent. Throws an ExpectationFailedException if the value is present.
     *
     * @throws ExpectationFailedException if the optional value is present.
     */
    public void absent() {
        validatePresent(true, "The value must be absent.");
    }

    /**
     * Validates that the optional value is absent, then executes the specified runnable.
     * Throws an ExpectationFailedException if the value is present.
     *
     * @param run The runnable to execute if the value is absent.
     * @throws ExpectationFailedException if the optional value is present.
     */
    public void absent(Runnable run) {
        validatePresent(true, "The value must be absent.");
        run.run();
    }

    /**
     * Validates that the optional value is absent, then executes the specified runnable.
     * Throws an ExpectationFailedException with a custom message if the value is present.
     *
     * @param run     The runnable to execute if the value is absent.
     * @param message The custom error message.
     * @param args    Additional arguments for formatting the message.
     * @throws ExpectationFailedException if the optional value is present.
     */
    public void absent(Runnable run, String message, Object... args) {
        validatePresent(true, message, args);
        run.run();
    }

    /**
     * Validates that the optional value is absent, then returns the result of the specified supplier.
     * Throws an ExpectationFailedException if the value is present.
     *
     * @param supplier The supplier to get the result if the value is absent.
     * @param <R>      The type of the result.
     * @return The result of the supplier.
     * @throws ExpectationFailedException if the optional value is present.
     */
    public <R> R absent(Supplier<R> supplier) {
        validatePresent(true, "The value must be absent.");
        return supplier.get();
    }

    /**
     * Validates that the optional value is absent, then returns the result of the specified supplier.
     * Throws an ExpectationFailedException with a custom message if the value is present.
     *
     * @param supplier The supplier to get the result if the value is absent.
     * @param message  The custom error message.
     * @param args     Additional arguments for formatting the message.
     * @param <R>      The type of the result.
     * @return The result of the supplier.
     * @throws ExpectationFailedException if the optional value is present.
     */
    public <R> R absent(Supplier<R> supplier, String message, Object... args) {
        validatePresent(true, message, args);
        return supplier.get();
    }

    public OptionalConstraint<T> ifAbsent(Runnable runnable) {
        if (!obj.isPresent()) {
            runnable.run();
        }

        return this;
    }

    public OptionalConstraint<T> ifPresent(Runnable runnable) {
        if (obj.isPresent()) {
            runnable.run();
        }

        return this;
    }

    public OptionalConstraint<T> ifPresent(Consumer<T> consumer) {
        if (obj.isPresent()) {
            consumer.accept(obj.get());
        }

        return this;
    }

    /**
     * Returns the value of the optional object if it is present.
     * Throws an ExpectationFailedException if the optional value is absent.
     *
     * @return The value of the optional object.
     * @throws ExpectationFailedException if the optional value is absent.
     */
    public T present() {
        validatePresent(false, "The value must be present.");
        return obj.get();
    }

    /**
     * Returns the value of the optional object if it is present.
     * Throws an ExpectationFailedException with a custom message if the optional value is absent.
     *
     * @param message The custom error message.
     * @param args    Additional arguments for formatting the message.
     * @return The value of the optional object.
     * @throws ExpectationFailedException if the optional value is absent.
     */
    public T present(String message, Object... args) {
        validatePresent(false, message, args);
        return obj.get();
    }

    /**
     * Returns the result of the specified supplier if the optional object is present.
     * Throws an ExpectationFailedException if the optional value is absent.
     *
     * @param supplier The supplier to get the result if the value is present.
     * @param <R>      The type of the result.
     * @return The result of the supplier.
     * @throws ExpectationFailedException if the optional value is absent.
     */
    public <R> R present(Supplier<R> supplier) {
        validatePresent(false, "The value must be present.");
        return supplier.get();
    }

    /**
     * Returns the result of the specified supplier if the optional object is present.
     * Throws an ExpectationFailedException with a custom message if the optional value is absent.
     *
     * @param supplier The supplier to get the result if the value is present.
     * @param message  The custom error message.
     * @param args     Additional arguments for formatting the message.
     * @param <R>      The type of the result.
     * @return The result of the supplier.
     * @throws ExpectationFailedException if the optional value is absent.
     */
    public <R> R present(Supplier<R> supplier, String message, Object... args) {
        validatePresent(false, message, args);
        return supplier.get();
    }

    private void validatePresent(boolean inverse, String message, Object... args) {
        if (inverse) {
            if (obj.isPresent()) {
                throw new ExpectationFailedException(String.format(message, args));
            }
        } else {
            if (!obj.isPresent()) {
                throw new ExpectationFailedException(String.format(message, args));
            }
        }
    }
}
