package com.game.bullsandcows.result;

import java.util.*;

public class GuessAndResultCheck {
    private static Map<Integer, Integer> secretNumbers = new HashMap<>();
    private static Map<Integer, Integer> guessedNumbers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int lengthNumber;

    public void playGame(boolean repeatStateCheck) throws InterruptedException {
        RepeatAndOptionCheck repeatAndOptionCheck = new RepeatAndOptionCheck();
        lengthNumber = repeatAndOptionCheck.getLengthNumber();
        secretNumbers = repeatAndOptionCheck.getSecretNumbers();

        boolean victory = false;
        while (!victory) {
            guessNumbers(repeatStateCheck);
            victory = checkResult();
        }
    }

    public void guessNumbers(boolean repeatStateCheck) {
        System.out.println("Угадайте " + lengthNumber + " цифры");
        Set<Integer> set = new HashSet<>();
        boolean checkNumbers = false;
        while (!checkNumbers) {
            guessedNumbers.clear();
            set.clear();
            for (int i = 0; i < lengthNumber; i++) {
                while (true) {
                    try {
                        int number = scanner.nextInt();
                        if (number < 0 || number >= 10) {
                            System.out.println("Вводить необходимо цифру от 0 до 9! Попробуйте еще раз!");
                            continue;
                        }
                        guessedNumbers.put(i, number);
                        set.add(number);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                        scanner.next();
                    }
                }
            }
            if (guessedNumbers.size() == lengthNumber) {
                if (!repeatStateCheck && set.size() < lengthNumber) {
                    System.out.println("Цифры не должны повторяться! Попробуйте еще раз!");
                } else {
                    checkNumbers = true;
                }
            }
        }
    }

    public boolean checkResult() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < lengthNumber; i++) {
            if (secretNumbers.containsValue(guessedNumbers.get(i)) && !secretNumbers.get(i).equals(guessedNumbers.get(i))) {
                sum1 = sum1 + 1;
            }
        }
        for (int i = 0; i < lengthNumber; i++) {
            if (secretNumbers.get(i).equals(guessedNumbers.get(i))) {
                sum2 = sum2 + 1;
            }
        }
        System.out.println("Результат: найдено " + sum1 + " коровы и " + sum2 + " быка");
        if (sum2 == lengthNumber) {
            System.out.println("Вы победили!");
            return true;
        } else {
            return false;
        }
    }

    public int[] checkResult(String secretNumber, String guessNumber) {
        lengthNumber = secretNumber.length();
        secretNumbers = convertStringToMap(secretNumber);
        guessedNumbers = convertStringToMap(guessNumber);

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < lengthNumber; i++) {
            if (secretNumbers.containsValue(guessedNumbers.get(i)) && !secretNumbers.get(i).equals(guessedNumbers.get(i))) {
                cows++;
            }
        }
        for (int i = 0; i < lengthNumber; i++) {
            if (secretNumbers.get(i).equals(guessedNumbers.get(i))) {
                bulls++;
            }
        }

        return new int[]{bulls, cows};
    }

    private Map<Integer, Integer> convertStringToMap(String number) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < number.length(); i++) {
            map.put(i, Character.getNumericValue(number.charAt(i)));
        }
        return map;
    }

    public static void setSecretNumbers(Map<Integer, Integer> secretNumbers) {
        GuessAndResultCheck.secretNumbers = secretNumbers;
    }

    public static void setGuessedNumbers(Map<Integer, Integer> guessedNumbers) {
        GuessAndResultCheck.guessedNumbers = guessedNumbers;
    }

    public static void setLengthNumber(int lengthNumber) {
        GuessAndResultCheck.lengthNumber = lengthNumber;
    }

    public static void setScanner(Scanner scanner) {
        GuessAndResultCheck.scanner = scanner;
    }

    public static int getLengthNumber() {
        return lengthNumber;
    }

    public static Map<Integer, Integer> getSecretNumbers() {
        return secretNumbers;
    }

    public static Map<Integer, Integer> getGuessedNumbers() {
        return guessedNumbers;
    }
}