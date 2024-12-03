package com.game.bullsandcows.input;

import com.game.bullsandcows.result.RepeatAndOptionCheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileInputStrategy implements InputStrategy {
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
            RepeatAndOptionCheck repeatAndOptionCheck = new RepeatAndOptionCheck();
            repeatAndOptionCheck.numberOptCheck();
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