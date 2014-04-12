package ru.home_work.february_2014.kozlov_leonid.nac.logic;

import ru.home_work.february_2014.kozlov_leonid.nac.logic.Cell;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Field;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Judge;

import java.util.Scanner;

public class Player {
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = -1;
    private int state = 0;

    public void setPlayerX() {
        state = PLAYER_X;
    }

    public void setPlayerO() {
        state = PLAYER_O;
    }

    public int getState() {
        return state;
    }


    public Cell selectNextCell(Judge judge) {
        Cell nextCell;
        int cellNumber;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите номер ячейки для хода игрока "+ this +" (от 0 до "+(Field.CELLS_COUNT-1)+"): ");
            cellNumber = in.nextInt();
            nextCell = judge.getField().getCell(cellNumber);
            if (nextCell == null) continue;
            if (nextCell.getPlayer() != null) continue;
            return nextCell;
        }
    }

    @Override
    public String toString() {
        if (state == PLAYER_X ) return "X";
        if (state == PLAYER_O ) return "O";
        return "-";
    }
}
