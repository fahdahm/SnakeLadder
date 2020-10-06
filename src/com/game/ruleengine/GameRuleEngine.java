package com.game.ruleengine;

import java.util.Map;

import com.game.model.Board;
import com.game.model.Cell;
import com.game.model.CrookedDice;
import com.game.model.Dice;
import com.game.model.RegularDice;

public class GameRuleEngine {

    private Dice  dice;
    private int   turns;
    private int   diceCount;
    private int   playerPos;
    private Board board;

    public String startGame(int turns, int boardSize, Map<Integer, Integer> snakes, boolean diceType) {
        if (boardSize <= 0) {
            return "Invalid Board Size";
        }
        this.turns = turns;
        initiateBoard(boardSize, snakes);
        playerPos = 0;
        if (diceType) {
            dice = new RegularDice();
        } else {
            dice = new CrookedDice();
        }
        startMovement(board, snakes);
        return "Game Finished";
    }

    private void initiateBoard(int boardSize, Map<Integer, Integer> snakes) {
        this.board = new Board(boardSize, snakes);
        initializePlayer(board);
    }

    private void initializePlayer(Board loadedBoard) {
        Cell updatedCell = loadedBoard.getCells().get(0);
        updatedCell.setHasPlayer(true);
        loadedBoard.getCells().remove(0);
        loadedBoard.getCells().add(0, updatedCell);
    }

    private void startMovement(Board board, Map<Integer, Integer> snakes) {
        for (int i = 0; i < turns && playerPos < board.getSize() - 1; i++) {
            diceCount = dice.throwDice();
            if (playerPos + diceCount < board.getSize()) {
                board.getCells().get(playerPos).setHasPlayer(false);
                playerPos += diceCount;
                if (snakes.containsKey(playerPos)) {
                    int snakeLength = snakes.get(playerPos);
                    playerPos -= snakeLength;
                    playerPos -= 1;
                    board.getCells().get(playerPos).setHasPlayer(true);
                } else {
                    board.getCells().get(playerPos).setHasPlayer(true);
                }
            } else {
                continue;
            }
        }
    }

    public Board getBoardState() {
        return board;
    }
}