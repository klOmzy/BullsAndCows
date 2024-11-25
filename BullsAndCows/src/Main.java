import java.util.*;

public class Main {
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
    private static Map<Integer, Integer> hashMap2 = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int lengthNumber;

    public static void main(String[] args) {
        boolean repeat = repeatNumbersCheck();
        writeNumbers(repeat);
        guessNumbers();
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

    public static void writeNumbers(boolean repeatStateCheck) {
        System.out.println("Введите желаемую длину исходного числа");
        lengthNumber = scanner.nextInt();
        System.out.println("Загадайте " + lengthNumber + " цифры");
        Set<Integer> set = new HashSet<>();
        while (true) {
            for (int i = 0; i < lengthNumber; i++) {
                int number = scanner.nextInt();
                if (number < 10) {
                    hashMap1.put(i, number);
                    set.add(number);
                } else {
                    System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                    writeNumbers(repeatStateCheck);
                    return;
                }
            }
            if (!repeatStateCheck && set.size() < lengthNumber) {
                System.out.println("Цифры не должны повторяться! Попробуйте еще раз!");
                continue;
            }
            break;
        }
    }

    public static void guessNumbers() {
        System.out.println("Угадайте четыре цифры");
        while (true) {
            for (int i = 0; i < lengthNumber; i++) {
                int number = scanner.nextInt();
                if (number < 10) {
                    hashMap2.put(i, number);
                } else {
                    System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                    guessNumbers();
                    return;
                }
            }
            break;
        }
        checkResult();
    }

    public static void checkResult() {
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
        } else {
            guessNumbers();
        }
    }
}