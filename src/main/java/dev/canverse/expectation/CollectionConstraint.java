package dev.canverse.expectation;

import java.util.Collection;
import java.util.function.Predicate;

public class CollectionConstraint<T extends Collection<T>> extends Constraint<T, CollectionConstraint<T>> {
    protected CollectionConstraint(T obj) {
        super(obj);
    }

    public CollectionConstraint<T> contains(T element) {
        if (!obj.contains(element)) {
            throw new ExpectationFailedException("Expected collection to contain the element, but it did not.");
        }

        return this;
    }

    public CollectionConstraint<T> contains(T element, String message, Object... args) {
        if (!obj.contains(element)) {
            throw new ExpectationFailedException(String.format(message, args));
        }

        return this;
    }

    public CollectionConstraint<T> contains(Predicate<? super T> predicate) {
        if (obj.stream().noneMatch(predicate)) {
            throw new ExpectationFailedException("Expected collection to not contain the element, but it did.");
        }

        return this;
    }

    public CollectionConstraint<T> contains(Predicate<? super T> predicate, String message, Object... args) {
        if (obj.stream().noneMatch(predicate)) {
            throw new ExpectationFailedException(String.format(message, args));
        }

        return this;
    }

    public CollectionConstraint<T> empty(String message, Object... args) {
        if (!obj.isEmpty()) {
            throw new ExpectationFailedException(String.format(message, args));
        }

        return this;
    }

    public CollectionConstraint<T> empty() {
        if (!obj.isEmpty()) {
            throw new ExpectationFailedException("Expected collection to be empty, but it was not.");
        }

        return this;
    }

    public CollectionConstraint<T> notNullOrEmpty(String message, Object... args) {
        if (obj == null || obj.isEmpty()) {
            throw new ExpectationFailedException(String.format(message, args));
        }

        return this;
    }

    public CollectionConstraint<T> notNullOrEmpty() {
        if (obj == null || obj.isEmpty()) {
            throw new ExpectationFailedException("Expected collection to not be empty, but it was.");
        }

        return this;
    }
}
