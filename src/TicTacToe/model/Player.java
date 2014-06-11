package TicTacToe.model;

import java.awt.*;

abstract public class Player {

       private String name;
       private String symbol;

       //Кол-во побед игрока
       private int winCount = 0;

   public Player(){}
   public Player(String symbol){
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return  this.symbol;
    }

    public int getWinCount() {
        return winCount;
    }

    public void incWinCount() {
        winCount++;
    }

    //Ход игрока
    abstract public void Move(Field field);
}
