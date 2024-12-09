package com.game.bullsandcows.input;

import java.util.Map;

public interface InputStrategy {
    void inputNumbers(boolean repeatStateCheck);
    int getLengthNumber();
    Map<Integer, Integer> getHashMap1();
}

