package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model;


public class Cell {
    private Player player = null;
    private int x;
    private int y;


    public Cell() {};

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        if (this.player == null) {
            return ".";
        } else {
            return this.player.getSymbol();
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
