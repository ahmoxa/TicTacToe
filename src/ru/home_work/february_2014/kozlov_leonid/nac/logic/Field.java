package ru.home_work.february_2014.kozlov_leonid.nac.logic;

public class Field {

    public static final int CELLS_COUNT = 9;   // Количество ячеек игрового поля
    private Cell[] cells;                       // Массив ячеек игрового поля

    public Field() {
        cells = new Cell[CELLS_COUNT];
        for (int i = 0; i < CELLS_COUNT; i++) cells[i] = new Cell();
    }

    public Cell getCell(int cellNumber) {
        if (cellNumber < 0) return null;
        if (cellNumber >= CELLS_COUNT) return null;
        return cells[cellNumber];
    }

    public boolean isEmpty() {
        for (int i = 0; i < CELLS_COUNT; i++) {
            if (cells[i].getPlayer() == null) return true;
        }
        return false;
    }





















    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < 9; i++) {
            Player player = this.getCell(i).getPlayer();
            if (player == null) {
                output += ".";
            } else {
                output += player;
            }
            if ((i == 2) | (i == 5) | (i == 8))  output += "\n";
        }
        return output;
    }

}
