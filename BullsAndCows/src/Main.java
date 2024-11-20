import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите включить повторяющиеся цифры? YES OR NO");
        String repeatCheck = scanner.nextLine();
        boolean repeat = false;
        if (repeatCheck.equals("YES") || repeatCheck.equals("Yes") || repeatCheck.equals("yes")) {
            repeat = true;
        } else if (repeatCheck.equals("NO") || repeatCheck.equals("No") || repeatCheck.equals("no")) {
            repeat = false;
        } else {
            System.out.println("Попробуйте еще раз!");
            return;
        }
        //System.out.println(repeat);
        System.out.println("Загадайте четыре цифры");
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            if (number < 10) {
                arrayList1.add(number);
            } else {
                System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                return;
            }
        }
        Set<Integer> set = new HashSet<>(arrayList1);
        boolean checkRepeat = set.size() < arrayList1.size();
        if (!repeat && checkRepeat) {
            System.out.println("Цифры не должны повторяться! Попробуйте еще раз!");
            return;
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.print(arrayList1.get(i));
        }
        System.out.println();
        System.out.println("Угадайте четыре цифры");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            if (number < 10) {
                arrayList2.add(number);
            } else {
                System.out.println("Вводить необходимо цифру! Попробуйте еще раз!");
                return;
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.print(arrayList2.get(i));
        }
        System.out.println();

        int sum1 = 0;
        for (int i = 0; i < arrayList2.size(); i++) {
            if(arrayList1.contains(arrayList2.get(i))){
                sum1 = sum1 + 1;
            }
        }
        int sum2 = 0;
        for (int i = 0; i < arrayList2.size(); i++) {
            if(arrayList1.get(i) == arrayList2.get(i)){
                sum2 = sum2 + 1;
            }
        }
        System.out.println("Нашел " + sum1 + " совпадений независимо от местоположения цифр и " + sum2 + " совпадений включая их позицию");
        if(sum2 == 4){
            System.out.println("Вы победили!");
        }
    }
}