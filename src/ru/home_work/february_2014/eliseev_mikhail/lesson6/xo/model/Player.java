package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model;

public class Player {

	private char symbol;
	private String name; // имя игрока (для ScoreBoard, например)

    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }
    
    public String getName() {
		return name;
	}
    
	public FieldPos nextMove(Cell[][] gameField) {
	    return new FieldPos(_randomPos(), _randomPos());
    }
    
    private int _randomPos() {
	    return (int)(Math.random() * Field.SIZE);
    }
}