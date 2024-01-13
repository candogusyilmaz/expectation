package dev.canverse.expectation;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Abstract class representing a constraint on a type T with a fluent interface for constraint handling.
 *
 * @param <T> The type of the object being constrained.
 * @param <C> The type of the concrete constraint class.
 */
@SuppressWarnings("unchecked")
public abstract class Constraint<T, C extends Constraint<T, C>> {
    protected final T obj;

    protected Constraint(T obj) {
        this.obj = obj;
    }

    /**
     * Applies the given consumer to the constrained object and returns the modified instance.
     *
     * @param consumer The consumer function to apply.
     * @return The current instance.
     */
    public C action(Consumer<T> consumer) {
        consumer.accept(obj);
        return (C) this;
    }

    /**
     * Gets the constrained object.
     *
     * @return The constrained object.
     */
    public T get() {
        return obj;
    }

    /**
     * Gets the result of applying the given function to the constrained object.
     *
     * @param function The function to apply.
     * @param <R>      The type of the result.
     * @return The result of applying the function.
     */
    public <R> R get(Function<T, R> function) {
        return function.apply(obj);
    }

    /**
     * Applies the given consumer if the object is not null and returns the modified instance.
     *
     * @param consumer The consumer to apply.
     * @return The current instance.
     */
    public C ifNotNull(Consumer<T> consumer) {
        if (obj != null) {
            consumer.accept(obj);
        }

        return (C) this;
    }

    /**
     * Applies the given supplier if the object is not null and returns the modified instance.
     * If the object is null or the supplier returns null, no action is taken.
     *
     * @param supplier The supplier to get the new value.
     * @return The current instance (modified if the object was not null and changes were made, unchanged otherwise).
     * @throws NullPointerException if the supplier returns null.
     */
    public C ifNotNull(Supplier<T> supplier) {
        if (obj != null) {
            T mightBeChanged = Objects.requireNonNull(supplier.get(), "The supplier must not return null.");

            if (!obj.equals(mightBeChanged)) {
                return (C) Expect.of(mightBeChanged);
            }
        }

        return (C) this;
    }

    /**
     * Performs the given action if the object is null and returns the modified instance.
     * If the object is not null, no action is taken.
     *
     * @param runnable The action to perform.
     * @return The current instance (unchanged if the object was not null, modified otherwise).
     */
    public C ifNull(Runnable runnable) {
        if (obj == null) {
            runnable.run();
        }

        return (C) this;
    }

    /**
     * Applies the given supplier if the object is null and returns the modified instance.
     * If the object is not null or the supplier returns null, no action is taken.
     *
     * @param supplier The supplier to get the new value.
     * @return The current instance (modified if the object was null and changes were made, unchanged otherwise).
     * @throws NullPointerException if the supplier returns null.
     */
    public C ifNull(Supplier<T> supplier) {
        if (obj == null) {
            return (C) Expect.of(Objects.requireNonNull(supplier.get(), "The supplier must not return null."));
        }

        return (C) this;
    }

    public C is(T value) {
        if (!obj.equals(value)) {
            throw new ExpectationFailedException("The value must be %s.", value);
        }

        return (C) this;
    }

    public C is(T value, String message, Object... args) {
        if (!obj.equals(value)) {
            throw new ExpectationFailedException(message, args);
        }

        return (C) this;
    }

    /**
     * Throws an ExpectationFailedException if the constrained object is not null.
     *
     * @return The current instance.
     * @throws ExpectationFailedException if the object is not null.
     */
    public C isNull() {
        if (obj != null) {
            throw new ExpectationFailedException("The object must be null.");
        }

        return (C) this;
    }

    /**
     * Throws an ExpectationFailedException with a custom message if the constrained object is not null.
     *
     * @param message The custom error message.
     * @param args    Additional arguments for formatting the message.
     * @return The current instance.
     * @throws ExpectationFailedException if the object is not null.
     */
    public C isNull(String message, Object... args) {
        if (obj != null) {
            throw new ExpectationFailedException(message, args);
        }

        return (C) this;
    }

    public C not(T value) {
        if (obj.equals(value)) {
            throw new ExpectationFailedException("The value must not be %s.", value);
        }

        return (C) this;
    }

    public C not(T value, String message, Object... args) {
        if (obj.equals(value)) {
            throw new ExpectationFailedException(message, args);
        }

        return (C) this;
    }

    /**
     * Throws an ExpectationFailedException if the constrained object is null.
     *
     * @return The current instance.
     * @throws ExpectationFailedException if the object is null.
     */
    public C notNull() {
        if (obj == null) {
            throw new ExpectationFailedException("The object must not be null.");
        }

        return (C) this;
    }

    /**
     * Throws an ExpectationFailedException with a custom message if the constrained object is null.
     *
     * @param message The custom error message.
     * @param args    Additional arguments for formatting the message.
     * @return The current instance.
     * @throws ExpectationFailedException if the object is null.
     */
    public C notNull(String message, Object... args) {
        if (obj == null) {
            throw new ExpectationFailedException(message, args);
        }

        return (C) this;
    }
}