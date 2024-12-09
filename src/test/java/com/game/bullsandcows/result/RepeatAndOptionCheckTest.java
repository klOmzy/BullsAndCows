package com.game.bullsandcows.result;

import com.game.bullsandcows.input.InputStrategy;
import com.game.bullsandcows.input.InputStrategyFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RepeatAndOptionCheckTest {

    private RepeatAndOptionCheck repeatAndOptionCheck;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() {
        repeatAndOptionCheck = new RepeatAndOptionCheck();
        originalIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    public void testRepeatNumbersCheckYes() {
        String input = "YES\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RepeatAndOptionCheck.setScanner(new Scanner(System.in));

        boolean result = repeatAndOptionCheck.repeatNumbersCheck();

        assertTrue(result);
        assertTrue(repeatAndOptionCheck.getRepeat());
    }

    @Test
    public void testRepeatNumbersCheckNo() {
        String input = "NO\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RepeatAndOptionCheck.setScanner(new Scanner(System.in));

        boolean result = repeatAndOptionCheck.repeatNumbersCheck();

        assertFalse(result);
        assertFalse(repeatAndOptionCheck.getRepeat());
    }

    @Test
    public void testRepeatNumbersCheckInvalidInput() {
        String input = "INVALID\nYES\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RepeatAndOptionCheck.setScanner(new Scanner(System.in));

        boolean result = repeatAndOptionCheck.repeatNumbersCheck();

        assertTrue(result);
        assertTrue(repeatAndOptionCheck.getRepeat());
    }

    @Test
    public void testNumberOptCheckOption1() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RepeatAndOptionCheck.setScanner(new Scanner(System.in));

        InputStrategy mockInputStrategy = mock(InputStrategy.class);
        try (MockedStatic<InputStrategyFactory> mockedFactory = mockStatic(InputStrategyFactory.class)) {
            mockedFactory.when(() -> InputStrategyFactory.createInputStrategy(1)).thenReturn(mockInputStrategy);

            repeatAndOptionCheck.numberOptCheck();

            verify(mockInputStrategy).inputNumbers(anyBoolean());
            assertEquals(mockInputStrategy.getLengthNumber(), repeatAndOptionCheck.getLengthNumber());
            assertEquals(mockInputStrategy.getSecretNumbers(), repeatAndOptionCheck.getSecretNumbers());
        }
    }

    @Test
    public void testNumberOptCheckOption2() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RepeatAndOptionCheck.setScanner(new Scanner(System.in));

        InputStrategy mockInputStrategy = mock(InputStrategy.class);
        try (MockedStatic<InputStrategyFactory> mockedFactory = mockStatic(InputStrategyFactory.class)) {
            mockedFactory.when(() -> InputStrategyFactory.createInputStrategy(2)).thenReturn(mockInputStrategy);

            repeatAndOptionCheck.numberOptCheck();

            verify(mockInputStrategy).inputNumbers(anyBoolean());
            assertEquals(mockInputStrategy.getLengthNumber(), repeatAndOptionCheck.getLengthNumber());
            assertEquals(mockInputStrategy.getSecretNumbers(), repeatAndOptionCheck.getSecretNumbers());
        }
    }

    @Test
    public void testNumberOptCheckInvalidInput() {
        String input = "3\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RepeatAndOptionCheck.setScanner(new Scanner(System.in));

        InputStrategy mockInputStrategy = mock(InputStrategy.class);
        try (MockedStatic<InputStrategyFactory> mockedFactory = mockStatic(InputStrategyFactory.class)) {
            mockedFactory.when(() -> InputStrategyFactory.createInputStrategy(1)).thenReturn(mockInputStrategy);

            repeatAndOptionCheck.numberOptCheck();

            verify(mockInputStrategy).inputNumbers(anyBoolean());
            assertEquals(mockInputStrategy.getLengthNumber(), repeatAndOptionCheck.getLengthNumber());
            assertEquals(mockInputStrategy.getSecretNumbers(), repeatAndOptionCheck.getSecretNumbers());
        }
    }
}
