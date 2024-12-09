package com.game.bullsandcows.input;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputStrategyTest {

    private final InputStream originalIn = System.in;
    private final ByteArrayInputStream testIn = new ByteArrayInputStream("3\n1\n2\n3\n".getBytes());

    @BeforeEach
    public void setUpStreams() {
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    void testInputNumbers() {
        ConsoleInputStrategy consoleInputStrategy = new ConsoleInputStrategy();
        consoleInputStrategy.inputNumbers(false);
        assertEquals(3, consoleInputStrategy.getSecretNumbers().size(), "HashMap должен содержать 3 цифры");
    }
}
