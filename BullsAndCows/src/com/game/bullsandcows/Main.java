package com.game.bullsandcows;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameControl gameControl = GameControl.getInstance();
        gameControl.startGame();
    }
}