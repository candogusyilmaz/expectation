package dev.canverse.expectation;

import java.time.chrono.ChronoLocalDateTime;

public final class Expect {
    private Expect() {
    }

    public static StringConstraint of(String obj) {
        return new StringConstraint(obj);
    }

    public static BooleanConstraint of(Boolean obj) {
        return new BooleanConstraint(obj);
    }

    public static <T extends Number & Comparable<T>> NumberConstraint<T> of(T obj) {
        return new NumberConstraint<>(obj);
    }

    public static <T extends ChronoLocalDateTime<?>> ChronoLocalDateTimeConstraint<T> of(T obj) {
        return new ChronoLocalDateTimeConstraint<>(obj);
    }
}
