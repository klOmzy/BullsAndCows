package com.game.bullsandcows.result;

import java.util.*;

public class GuessAndResultCheck {
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
    private static Map<Integer, Integer> hashMap2 = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int lengthNumber;

    public void guessNumbers(boolean repeatStateCheck) throws InterruptedException {
        RepeatAndOptionCheck repeatAndOptionCheck = new RepeatAndOptionCheck();
        lengthNumber = repeatAndOptionCheck.getLengthNumber();
        hashMap1 = repeatAndOptionCheck.getHashMap1();

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
            if(hashMap2.size()==lengthNumber) {
                if (!repeatStateCheck && set.size()< lengthNumber) {
                    System.out.println("Цифры не должны повторяться! Попробуйте еще раз!");
                } else {
                    checkNumbers = true;
                }
            }
        }
        checkResult(repeatStateCheck);
    }

    public void checkResult(boolean repeatStateCheck) throws InterruptedException {
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
            Thread.sleep(15000);
        } else {
            guessNumbers(repeatStateCheck);
        }
    }

    public int[] checkResult(String originalNumber, String guessedNumber) {
        int bulls = 0;
        int cows = 0;

        Map<Integer, Integer> originalMap = new HashMap<>();
        Map<Integer, Integer> guessedMap = new HashMap<>();

        for (int i = 0; i < originalNumber.length(); i++) {
            originalMap.put(i, Character.getNumericValue(originalNumber.charAt(i)));
            guessedMap.put(i, Character.getNumericValue(guessedNumber.charAt(i)));
        }

        for (int i = 0; i < originalNumber.length(); i++) {
            if (originalMap.get(i).equals(guessedMap.get(i))) {
                bulls++;
            } else if (originalMap.containsValue(guessedMap.get(i))) {
                cows++;
            }
        }

        return new int[]{bulls, cows};
    }
}
