package com.game.bullsandcows.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputStrategyFactoryTest {

    @Test
    void testCreateInputStrategyConsole() {
        InputStrategy strategy = InputStrategyFactory.createInputStrategy(1);
        assertTrue(strategy instanceof ConsoleInputStrategy, "Выбранная страгеия должна быть ConsoleInputStrategy");
    }

    @Test
    void testCreateInputStrategyFile() {
        InputStrategy strategy = InputStrategyFactory.createInputStrategy(2);
        assertTrue(strategy instanceof FileInputStrategy, "Выбранная страгеия должна быть FileInputStrategy");
    }

    @Test
    void testCreateInputStrategyInvalidOption() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputStrategyFactory.createInputStrategy(3);
        });
    }
}
