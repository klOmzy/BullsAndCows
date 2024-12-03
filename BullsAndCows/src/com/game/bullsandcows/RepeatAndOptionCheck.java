package com.game.bullsandcows;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatAndOptionCheck {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean repeat = repeatNumbersCheck();
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
    private static int lengthNumber;

    private static boolean repeatNumbersCheck() {
        while (true) {
            System.out.println("Хотите включить повторяющиеся цифры? YES OR NO");
            String repeatCheck = scanner.nextLine();
            if (repeatCheck.equalsIgnoreCase("YES")) {
                return true;
            } else if (repeatCheck.equalsIgnoreCase("NO")) {
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
                hashMap1 = inputStrategy.getHashMap1();
                numbersOptCheck = true;
            } else {
                System.out.println("Необходимо вводить 1 или 2");
            }
        }
    }
    public int getLengthNumber() {
        return lengthNumber;
    }
    public Map<Integer, Integer> getHashMap1() {
        return hashMap1;
    }
    public boolean getRepeat(){
        return repeat;
    }
}
