import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InputStrategyFactory {
    public static InputStrategy createInputStrategy(int option) {
        switch (option) {
            case 1:
                return new ConsoleInputStrategy();
            case 2:
                return new FileInputStrategy();
            default:
                throw new IllegalArgumentException("Invalid option");
        }
    }
}

class ConsoleInputStrategy implements InputStrategy {
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
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
            hashMap1.clear();
            set.clear();
            for (int i = 0; i < lengthNumber; i++) {
                int number = scanner.nextInt();
                if (number < 10) {
                    hashMap1.put(i, number);
                    set.add(number);
                } else {
                    System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                    break;
                }
            }
            if(hashMap1.size()==lengthNumber) {
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
    public Map<Integer, Integer> getHashMap1() {
        return hashMap1;
    }
}

class FileInputStrategy implements InputStrategy {
    private static Map<Integer, Integer> hashMap1 = new HashMap<>();
    private static int lengthNumber;

    @Override
    public void inputNumbers(boolean repeatStateCheck) {
        String path = "BullsAndCows/numbers.txt";
        boolean checkNumbers = true;
        Set<Integer> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int mapKey = 0;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                int key = mapKey++;
                hashMap1.put(key, number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lengthNumber = hashMap1.size();
        for (int i = 0; i < lengthNumber; i++) {
            if (hashMap1.get(i) < 10) {
                set.add(hashMap1.get(i));
            } else {
                System.out.println("Вводить необходимо цифру! Измените исходный файл!");
                hashMap1.clear();
                set.clear();
                checkNumbers = false;
            }
        }
        if(hashMap1.size()==lengthNumber) {
            if (!repeatStateCheck && set.size() < lengthNumber) {
                System.out.println("Цифры не должны повторяться! Измените исходный файл!");
                hashMap1.clear();
                set.clear();
                checkNumbers = false;
            }
        }
        if(!checkNumbers){
            GameControl.getInstance().numberOptCheck();
        }
    }
    @Override
    public int getLengthNumber() {
        return lengthNumber;
    }
    @Override
    public Map<Integer, Integer> getHashMap1() {
        return hashMap1;
    }
}
