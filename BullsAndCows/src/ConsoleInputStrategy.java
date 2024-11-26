import java.util.*;

public class ConsoleInputStrategy implements InputStrategy {
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
