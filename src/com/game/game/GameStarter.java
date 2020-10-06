package com.game.game;

import java.util.HashMap;
import java.util.Map;

import com.game.model.Board;
import com.game.model.Cell;
import com.game.ruleengine.GameRuleEngine;

public class GameStarter {
    public static void main(String[] args) {
        int turnsToBePlayed = 10;
        int boardSize = 100;
        boolean isRegularDice = false;
        int snakeStart[] = { 14, 18 };
        int snakeLength[] = { 7, 12 };

        Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
        for (int i = 0; i < snakeStart.length; i++) {
            snakes.put(snakeStart[i], snakeLength[i]);
        }

        GameRuleEngine gameEngine = new GameRuleEngine();
        gameEngine.startGame(turnsToBePlayed, boardSize, snakes, isRegularDice);
        Board finalBoardState = gameEngine.getBoardState();
        for (Cell cell : finalBoardState.getCells()) {
            System.out.println(cell);
        }
    }
}