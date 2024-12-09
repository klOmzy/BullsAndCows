package com.game.bullsandcows.input;

import java.util.*;

public class ConsoleInputStrategy implements InputStrategy {
    private static Map<Integer, Integer> secretNumbers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int lengthNumber;

    @Override
    public void inputNumbers(boolean repeatStateCheck) {
        System.out.println("Введите желаемую длину исходного числа");
        lengthNumber = scanner.nextInt();
        System.out.println("Загадайте " + lengthNumber + " цифры");
        Set<Integer> set = new HashSet<>();
        boolean checkNumbers = false;
        while (!checkNumbers) {
            secretNumbers.clear();
            set.clear();
            for (int i = 0; i < lengthNumber; i++) {
                while (true) {
                    try {
                        int number = scanner.nextInt();
                        if (number < 0 || number >= 10) {
                            System.out.println("Вводить необходимо цифру от 0 до 9! Попробуйте еще раз!");
                            continue;
                        }
                        secretNumbers.put(i, number);
                        set.add(number);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                        scanner.next();
                    }
                }
            }
            if(secretNumbers.size()==lengthNumber) {
                if (!repeatStateCheck && set.size() < lengthNumber) {
                    System.out.println("Цифры не должны повторяться! Попробуйте еще раз!");
                } else {
                    checkNumbers = true;
                }
            }
        }
    }
    @Override
    public int getLengthNumber() {
        return lengthNumber;
    }
    @Override
    public Map<Integer, Integer> getSecretNumbers() {
        return secretNumbers;
    }
}
