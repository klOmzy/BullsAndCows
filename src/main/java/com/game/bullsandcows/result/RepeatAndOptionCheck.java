package com.game.bullsandcows.result;

import com.game.bullsandcows.input.InputStrategy;
import com.game.bullsandcows.input.InputStrategyFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatAndOptionCheck {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean repeat;
    private static Map<Integer, Integer> secretNumbers = new HashMap<>();
    private static int lengthNumber;

    public static boolean repeatNumbersCheck() {
        while (true) {
            System.out.println("Хотите включить повторяющиеся цифры? YES OR NO");
            String repeatCheck = scanner.nextLine();
            if (repeatCheck.equalsIgnoreCase("YES")) {
                repeat = true;
                return true;
            } else if (repeatCheck.equalsIgnoreCase("NO")) {
                repeat = false;
                return false;
            } else {
                System.out.println("Попробуйте еще раз!");
            }
        }
    }
    public void numberOptCheck(){
        System.out.println("Хотите загадать цифры с консоли (1) или считать с файла (2). Введите 1 или 2");
        boolean numbersOptCheck = false;
        while (!numbersOptCheck) {
            int numbersOpt = scanner.nextInt();
            if(numbersOpt==1 || numbersOpt==2){
                InputStrategy inputStrategy = InputStrategyFactory.createInputStrategy(numbersOpt);
                inputStrategy.inputNumbers(repeat);
                lengthNumber = inputStrategy.getLengthNumber();
                secretNumbers = inputStrategy.getSecretNumbers();
                numbersOptCheck = true;
            } else {
                System.out.println("Необходимо вводить 1 или 2");
            }
        }
    }
    public int getLengthNumber() {
        return lengthNumber;
    }
    public Map<Integer, Integer> getSecretNumbers() {
        return secretNumbers;
    }
    public boolean getRepeat(){
        return repeat;
    }

    public static void setSecretNumbers(Map<Integer, Integer> secretNumbers) {
        RepeatAndOptionCheck.secretNumbers = secretNumbers;
    }

    public static void setLengthNumber(int lengthNumber) {
        RepeatAndOptionCheck.lengthNumber = lengthNumber;
    }

    public static void setRepeat(boolean repeat) {
        RepeatAndOptionCheck.repeat = repeat;
    }

    public static void setScanner(Scanner scanner) {
        RepeatAndOptionCheck.scanner = scanner;
    }
}
