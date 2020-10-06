package com.game.model;

import java.util.Random;

public class CrookedDice implements Dice {

    private final Random rand = new Random();

    @Override
    public int throwDice() {
        return 2 + rand.nextInt(3) * 2;
    }
}