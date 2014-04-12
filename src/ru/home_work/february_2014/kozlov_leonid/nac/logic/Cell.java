package ru.home_work.february_2014.kozlov_leonid.nac.logic;

public class Cell {

    private Player player = null;
    private int weight = 0;
    private boolean winCell = false;

    public Player getPlayer() {
        return player;
    }

    public void makeMove(Player player) {
        if (this.player != null) return;
        this.player = player;
    }

    public void initWeight() {
        weight = 0;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (this.player == null) {
            if (this.weight < weight) {
                this.weight = weight;
            }
        } else weight = 0;
    }

    public boolean isWinCell() {
        return winCell;
    }

    public void setWinCell() {
        winCell = true;
    }

}
