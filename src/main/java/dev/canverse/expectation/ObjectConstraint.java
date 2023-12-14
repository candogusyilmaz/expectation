package dev.canverse.expectation;

public class ObjectConstraint<T> extends Constraint<T, ObjectConstraint<T>> {
    protected ObjectConstraint(T obj) {
        super(obj);
    }
}
