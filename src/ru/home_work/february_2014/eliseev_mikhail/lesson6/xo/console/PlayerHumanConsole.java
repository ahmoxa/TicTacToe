package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.console;

import ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model.*;

class PlayerHumanConsole extends Player {
	
	public PlayerHumanConsole(char symbol, String name) {
        super(symbol, name);
    }
	
	@Override
	public FieldPos nextMove(Cell[][] gameField) {
		while (true) {
			GameHelper userInput = new GameHelper(); // вспомогательный класс для ввода с клавиатуры
			String str = userInput.getUserInput("Input number of cell (a digit from 1 to 9):");
			int n = Integer.parseInt(str);
			if (n >= 1 && n <= 9) {
				return FieldPos.num2pos(n);	
			}
			System.out.print("Use digit from 1 to 9. ");
		}
	}
}