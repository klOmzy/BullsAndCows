package com.game.bullsandcows.input;

import com.game.bullsandcows.result.RepeatAndOptionCheck;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileInputStrategy implements InputStrategy {
    private static Map<Integer, Integer> secretNumbers = new HashMap<>();
    private static int lengthNumber;

    @Override
    public void inputNumbers(boolean repeatStateCheck) {
        String path = "numbers.txt";
        boolean checkNumbers = true;
        Set<Integer> set = new HashSet<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new IOException("File not found: " + path);
            }
            String line;
            int mapKey = 0;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                int key = mapKey++;
                secretNumbers.put(key, number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lengthNumber = secretNumbers.size();
        for (int i = 0; i < lengthNumber; i++) {
            if (secretNumbers.get(i) < 10) {
                set.add(secretNumbers.get(i));
            } else {
                System.out.println("Вводить необходимо цифру! Измените исходный файл!");
                secretNumbers.clear();
                set.clear();
                checkNumbers = false;
            }
        }
        if(secretNumbers.size()==lengthNumber) {
            if (!repeatStateCheck && set.size() < lengthNumber) {
                System.out.println("Цифры не должны повторяться! Измените исходный файл!");
                secretNumbers.clear();
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
    public Map<Integer, Integer> getSecretNumbers() {
        return secretNumbers;
    }
}