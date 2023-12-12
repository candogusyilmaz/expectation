package dev.canverse.expectation;

import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class Constraint<T, C extends Constraint<T, C>> {
    protected final T obj;

    protected Constraint(T obj) {
        this.obj = obj;
    }

    public C action(Consumer<T> action) {
        action.accept(obj);
        return (C) this;
    }

    public T get() {
        return obj;
    }

    public <R> R get(Function<T, R> action) {
        return action.apply(obj);
    }

    public C notNull(String message, Object... args) {
        if (obj == null) {
            throw new ExpectationFailedException(message, args);
        }

        return (C) this;
    }

    public C notNull() {
        if (obj == null) {
            throw new ExpectationFailedException("The object must not be null.");
        }

        return (C) this;
    }
}