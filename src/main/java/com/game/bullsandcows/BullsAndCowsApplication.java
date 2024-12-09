package com.game.bullsandcows;

public class BullsAndCowsApplication {
    public static void main(String[] args) throws InterruptedException {
        GameControl gameControl = GameControl.getInstance();
        gameControl.startGame();
    }
}