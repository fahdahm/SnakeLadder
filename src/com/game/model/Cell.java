package com.game.model;

public class Cell {
    private boolean hasPlayer;
    private boolean hasSnake;
    private boolean isEnd;

    public Cell(boolean hasPlayer, boolean hasSnake, boolean isEnd) {
        super();
        this.hasPlayer = hasPlayer;
        this.hasSnake = hasSnake;
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }

    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }

    public boolean hasSnake() {
        return hasSnake;
    }

    public void setHasSnake(boolean hasSnake) {
        this.hasSnake = hasSnake;
    }

    @Override
    public String toString() {
        return "Cell [isPlayer=" + hasPlayer + ", isSnake=" + hasSnake + ", isEnd=" + isEnd + "]";
    }
}