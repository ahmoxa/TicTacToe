package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model;


public class Field {
    private final static int FIELD_SIZE = 3;
    Cell[][] cells = new Cell[FIELD_SIZE][FIELD_SIZE];


    public Field(){
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public int getFIELD_SIZE() {
        return this.FIELD_SIZE;
    }

    public Cell getCell (int x, int y){
        return this.cells[x][y];
    }

    public void Display(){
        for (int i = 0; i < this.getFIELD_SIZE(); i++){
            for (int j = 0; j < this.getFIELD_SIZE(); j++) {
                System.out.print(this.getCell(i,j));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }


}
