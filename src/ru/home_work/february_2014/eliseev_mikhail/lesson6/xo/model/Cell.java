package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model;

public class Cell {

    private Player player = null;
    
    public void setPlayer(Player player) {
	    this.player = player;
    }
    
    public Player getPlayer() {
	    return player;
    }

    @Override
    public String toString() {
        if (player == null) {
            return ".";
        } else {
            return "" + player.getSymbol();
        }
    }
}