package com.game.bullsandcows.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileInputStrategyTest {

    @Test
    void testInputNumbers() {
        FileInputStrategy fileInputStrategy = new FileInputStrategy();
        fileInputStrategy.inputNumbers(false);
        assertTrue(fileInputStrategy.getSecretNumbers().size() > 0, "HashMap не должен быть пустым");
    }
}
