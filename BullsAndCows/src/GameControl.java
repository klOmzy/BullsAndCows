import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameControl {
    private static GameControl instance;
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
    private static Map<Integer, Integer> hashMap2 = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int lengthNumber;
    private static boolean repeat = repeatNumbersCheck();

    private GameControl(){
        //
    }
    public static GameControl getInstance() {
        if (instance == null) {
            instance = new GameControl();
        }
        return instance;
    }

    public void startGame() throws InterruptedException {
        numberOptCheck();
        guessNumbers(repeat);
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
    public static boolean repeatNumbersCheck() {
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
    public void guessNumbers(boolean repeatStateCheck) throws InterruptedException {
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
        checkResult();
    }
    public void checkResult() throws InterruptedException {
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
            guessNumbers(repeat);
        }
    }
}