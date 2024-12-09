package com.game.bullsandcows.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

        assertEquals(expectedHashMap, GuessAndResultCheck.getHashMap2());
    }

    @Test
    void testCheckResult() {
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        hashMap1.put(0, 1);
        hashMap1.put(1, 2);
        hashMap1.put(2, 3);
        hashMap1.put(3, 4);

        Map<Integer, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(0, 1);
        hashMap2.put(1, 2);
        hashMap2.put(2, 3);
        hashMap2.put(3, 4);

        GuessAndResultCheck.setHashMap1(hashMap1);
        GuessAndResultCheck.setHashMap2(hashMap2);
        GuessAndResultCheck.setLengthNumber(4);

        assertTrue(guessAndResultCheck.checkResult());
    }

    @Test
    void testCheckResultWithCows() {
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        hashMap1.put(0, 1);
        hashMap1.put(1, 2);
        hashMap1.put(2, 3);
        hashMap1.put(3, 4);

        Map<Integer, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(0, 4);
        hashMap2.put(1, 3);
        hashMap2.put(2, 2);
        hashMap2.put(3, 1);

        GuessAndResultCheck.setHashMap1(hashMap1);
        GuessAndResultCheck.setHashMap2(hashMap2);
        GuessAndResultCheck.setLengthNumber(4);

        assertFalse(guessAndResultCheck.checkResult());
    }
}

