package com.game.bullsandcows;

import java.util.Map;

public interface InputStrategy {
    void inputNumbers(boolean repeatStateCheck);
    int getLengthNumber();
    Map<Integer, Integer> getHashMap1();
}

