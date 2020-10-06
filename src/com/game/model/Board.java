package com.game.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
    private final int             SIZE;
    private List<Cell>            cells;
    // Snake Position and length
    private Map<Integer, Integer> snakes;

    public Board(int size, Map<Integer, Integer> snakes) {
        this.SIZE = size;
        this.snakes = snakes;
        cells = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            if (snakes.containsKey(i + 1)) {
                cells.add(i, new Cell(false, true, false));
            } else {
                cells.add(i, new Cell(false, false, false));
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }
}