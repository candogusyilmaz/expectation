package dev.canverse.expectation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstraintTests {

    @Test
    void notNull() {
        assertThrows(ExpectationFailedException.class, () -> Expect.of((String) null).notNull());
        assertDoesNotThrow(() -> Expect.of("").notNull());
    }

    @Test
    void action() {
        assertDoesNotThrow(() -> Expect.of("").action(s -> {
            assertEquals("", s);
        }));
    }

    @Test
    void get() {
        assertEquals("", Expect.of("").get());
        assertEquals(1, Expect.of(1).get());
    }

    @Test
    void getFunction() {
        Integer a = 5;
        Long b = 5L;

        assertEquals(a, Expect.of(a).get(s -> s));
        assertEquals(b, Expect.of(b).get(s -> s));
        assertEquals("", Expect.of("").get(s -> s));
    }
}
