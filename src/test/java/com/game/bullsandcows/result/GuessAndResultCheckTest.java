package com.game.bullsandcows.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuessAndResultCheckTest {

    private GuessAndResultCheck guessAndResultCheck;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        guessAndResultCheck = new GuessAndResultCheck();
        scanner = mock(Scanner.class);
        GuessAndResultCheck.setScanner(scanner);
    }

    @Test
    void testGuessNumbers() {
        when(scanner.nextInt()).thenReturn(1, 2, 3, 4);

        GuessAndResultCheck.setLengthNumber(4);
        guessAndResultCheck.guessNumbers(false);

        Map<Integer, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put(0, 1);
        expectedHashMap.put(1, 2);
        expectedHashMap.put(2, 3);
        expectedHashMap.put(3, 4);

        assertEquals(expectedHashMap, GuessAndResultCheck.getGuessedNumbers());
    }

    @Test
    void testCheckResult() {
        Map<Integer, Integer> secretNumbers = new HashMap<>();
        secretNumbers.put(0, 1);
        secretNumbers.put(1, 2);
        secretNumbers.put(2, 3);
        secretNumbers.put(3, 4);

        Map<Integer, Integer> guessedNumbers = new HashMap<>();
        guessedNumbers.put(0, 1);
        guessedNumbers.put(1, 2);
        guessedNumbers.put(2, 3);
        guessedNumbers.put(3, 4);

        GuessAndResultCheck.setSecretNumbers(secretNumbers);
        GuessAndResultCheck.setGuessedNumbers(guessedNumbers);
        GuessAndResultCheck.setLengthNumber(4);

        assertTrue(guessAndResultCheck.checkResult());
    }

    @Test
    void testCheckResultWithCows() {
        Map<Integer, Integer> secretNumbers = new HashMap<>();
        secretNumbers.put(0, 1);
        secretNumbers.put(1, 2);
        secretNumbers.put(2, 3);
        secretNumbers.put(3, 4);

        Map<Integer, Integer> guessedNumbers = new HashMap<>();
        guessedNumbers.put(0, 4);
        guessedNumbers.put(1, 3);
        guessedNumbers.put(2, 2);
        guessedNumbers.put(3, 1);

        GuessAndResultCheck.setSecretNumbers(secretNumbers);
        GuessAndResultCheck.setGuessedNumbers(guessedNumbers);
        GuessAndResultCheck.setLengthNumber(4);

        assertFalse(guessAndResultCheck.checkResult());
    }
}

