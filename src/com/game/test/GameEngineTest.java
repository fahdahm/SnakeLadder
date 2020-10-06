package com.game.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.game.model.Board;
import com.game.ruleengine.GameRuleEngine;

public class GameEngineTest {
    GameRuleEngine engine = new GameRuleEngine();

    @Test
    public void startGameTest_validBoardSize_pass() {
        engine.startGame(10, 100, getSnakes(), true);
        Board actualBoard = engine.getBoardState();
        assertEquals(100, actualBoard.getCells().size());
    }

    @Test
    public void startGameTest_invalidBoardSize_fail() {
        String gameStatus = engine.startGame(10, 0, getSnakes(), true);
        assertEquals("Invalid Board Size", gameStatus);
    }

    @Test
    public void startGameTest_zeroTurns_pass() {
        engine.startGame(0, 100, getSnakes(), true);
        Board actualBoard = engine.getBoardState();
        assertEquals(true, actualBoard.getCells().get(0).hasPlayer());
    }

    @Test
    public void startGameTest_snakePos_pass() {
        engine.startGame(10, 100, getSnakes(), true);
        Board actualBoard = engine.getBoardState();
        assertEquals(true, actualBoard.getCells().get(13).hasSnake());
        assertEquals(true, actualBoard.getCells().get(17).hasSnake());
    }

    private Map<Integer, Integer> getSnakes() {
        int snakeStart[] = { 14, 18 };
        int snakeLength[] = { 7, 12 };
        Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
        for (int i = 0; i < snakeStart.length; i++) {
            snakes.put(snakeStart[i], snakeLength[i]);
        }
        return snakes;
    }
}