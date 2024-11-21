import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = repeatNumbersCheck();
        System.out.println("Загадайте четыре цифры");
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            if (number < 10) {
                hashMap1.put(i, number);
                set.add(number);
            } else {
                System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                return;
            }
        }
        if (!repeat && set.size() < 4) {
            System.out.println("Цифры не должны повторяться! Попробуйте еще раз!");
            return;
        }
        for (int i = 0; i < hashMap1.size(); i++) {
            System.out.print(hashMap1.get(i));
        }
        System.out.println();
        System.out.println("Угадайте четыре цифры");
        Map<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            if (number < 10) {
                hashMap2.put(i, number);
            } else {
                System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                return;
            }
        }
        for (int i = 0; i < hashMap2.size(); i++) {
            System.out.print(hashMap2.get(i));
        }
        System.out.println();

        int sum1 = 0;
        for (int i = 0; i < 4; i++) {
            if (hashMap1.containsValue(hashMap2.get(i)) && !hashMap1.get(i).equals(hashMap2.get(i))) {
                sum1 = sum1 + 1;
            }
        }
        int sum2 = 0;
        for (int i = 0; i < 4; i++) {
            if (hashMap1.get(i).equals(hashMap2.get(i))) {
                sum2 = sum2 + 1;
            }
        }
        System.out.println("Результат: найдено " + sum1 + " коровы и " + sum2 + " быка");
        if(sum2 == 4){
            System.out.println("Вы победили!");
        }
    }
    public static boolean repeatNumbersCheck(){
        Scanner scanner = new Scanner(System.in);
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
}