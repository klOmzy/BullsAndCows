package com.game.bullsandcows.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputStrategyFactoryTest {

    @Test
    void testCreateInputStrategyConsole() {
        InputStrategy strategy = InputStrategyFactory.createInputStrategy(1);
        assertTrue(strategy instanceof ConsoleInputStrategy, "Strategy should be ConsoleInputStrategy");
    }

    @Test
    void testCreateInputStrategyFile() {
        InputStrategy strategy = InputStrategyFactory.createInputStrategy(2);
        assertTrue(strategy instanceof FileInputStrategy, "Strategy should be FileInputStrategy");
    }

    @Test
    void testCreateInputStrategyInvalidOption() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputStrategyFactory.createInputStrategy(3);
        });
    }
}
