package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model;

public class FieldPos {

	public int y;
	public int x;
    
    public FieldPos(int y, int x) {
	    this.y = y;
	    this.x = x;
    }
    
	// преобразует двухмерную координату (индексы массива) в одномерную (номер клетки)
	public static int pos2num(int y, int x) {
		return y * Field.SIZE + x + 1;
	}
	
	// преобразует одномерную координату в двухмерный индекс массива (y, x)
	public static FieldPos num2pos(int num) {
		int y = --num / Field.SIZE;
		int x = num % Field.SIZE;
		return new FieldPos(y, x);
	}
}