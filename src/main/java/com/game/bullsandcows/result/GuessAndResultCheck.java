package com.game.bullsandcows.result;

import java.util.*;

public class GuessAndResultCheck {
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
    private static Map<Integer, Integer> hashMap2 = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int lengthNumber;

    public void playGame(boolean repeatStateCheck) throws InterruptedException {
        RepeatAndOptionCheck repeatAndOptionCheck = new RepeatAndOptionCheck();
        lengthNumber = repeatAndOptionCheck.getLengthNumber();
        hashMap1 = repeatAndOptionCheck.getHashMap1();

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
            hashMap2.clear();
            set.clear();
            for (int i = 0; i < lengthNumber; i++) {
                int number = scanner.nextInt();
                if (number < 10) {
                    hashMap2.put(i, number);
                    set.add(number);
                } else {
                    System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                    break;
                }
            }
            if (hashMap2.size() == lengthNumber) {
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
            if (hashMap1.containsValue(hashMap2.get(i)) && !hashMap1.get(i).equals(hashMap2.get(i))) {
                sum1 = sum1 + 1;
            }
        }
        for (int i = 0; i < lengthNumber; i++) {
            if (hashMap1.get(i).equals(hashMap2.get(i))) {
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
        hashMap1 = convertStringToMap(secretNumber);
        hashMap2 = convertStringToMap(guessNumber);

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < lengthNumber; i++) {
            if (hashMap1.containsValue(hashMap2.get(i)) && !hashMap1.get(i).equals(hashMap2.get(i))) {
                cows++;
            }
        }
        for (int i = 0; i < lengthNumber; i++) {
            if (hashMap1.get(i).equals(hashMap2.get(i))) {
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

    public static void setHashMap1(Map<Integer, Integer> hashMap1) {
        GuessAndResultCheck.hashMap1 = hashMap1;
    }

    public static void setHashMap2(Map<Integer, Integer> hashMap2) {
        GuessAndResultCheck.hashMap2 = hashMap2;
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

    public static Map<Integer, Integer> getHashMap1() {
        return hashMap1;
    }

    public static Map<Integer, Integer> getHashMap2() {
        return hashMap2;
    }
}