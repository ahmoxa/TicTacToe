package TicTacToe.console;

import TicTacToe.model.*;


import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerHuman extends Player {

    public PlayerHuman(String symbol) {
        super(symbol);
    }


    @Override
    public void Move(Field field) {
        Cell move = this.InputMove(field);
        if (move != null && checkTurn(move.getX(),move.getY(),field)){
            field.getCell(move.getX(),move.getY()).setPlayer(this);
        } else {
            System.out.print("Incorrect input\n");
            Move(field);
        }
    }

    //Ход игрока через консоль
    public Cell InputMove(Field field) {
        Cell cmove = new Cell();
        int x;
        int y;
        System.out.println("Input your turn Player " + this.getSymbol() + ":");
        Scanner s = new Scanner(System.in);
        try {
            cmove.setX(s.nextInt());
            cmove.setY(s.nextInt());
        } catch (InputMismatchException e) {
            System.out.print("Incorrect input e\n");
            return null;
        }
        return cmove;
    }

    //Проверка корректности хода
    public boolean checkTurn(int x, int y, Field field){
        if (x > field.getFIELD_SIZE() ||
                y > field.getFIELD_SIZE() ||
                x < 0 ||
                y < 0 ||
                field.getCell(x, y).getPlayer() !=null) {
            return false;
        } else {
            return true;
        }
    }


}
