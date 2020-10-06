package com.game.model;

import java.util.Random;

public class RegularDice implements Dice {

    private final Random rand = new Random();

    @Override
    public int throwDice() {
        return 1 + rand.nextInt(6);
    }
}