package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.gui;

import ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model.*;

class PlayerHumanGUI extends Player {
	
	public PlayerHumanGUI(char symbol, String name) {
        super(symbol, name);
    }
	
	@Override
	public FieldPos nextMove(Cell[][] gameField) {
		return new FieldPos(0, 0); // в случае PlayerHumanGUI, ход выбирается при клике на клетку поля, а не в этом методе
	}
}