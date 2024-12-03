package com.game.bullsandcows;

public class InputStrategyFactory {

    public static InputStrategy createInputStrategy(int option) {
        switch (option) {
            case 1:
                return new ConsoleInputStrategy();
            case 2:
                return new FileInputStrategy();
            default:
                throw new IllegalArgumentException("Некорректный ввод");
        }
    }
}
