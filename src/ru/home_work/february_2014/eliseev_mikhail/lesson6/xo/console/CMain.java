package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.console;

import ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model.*;

public class CMain {

	public CMain() {
    
    	// Field field = new Field(new PlayerAi('x', "noname"), new Player('o', "noname")); // Ai vs Dummy
    	Field field = new Field(new PlayerAi('x', "noname"), new PlayerHumanConsole('o', "noname")); // Ai vs Human
        
        System.out.println(field);
        
        while (true) {
        
			Player player = field.getCurPlayer();
			System.out.println(player.getSymbol() + "'s turn:");
			
			delay(800);
			
			while (!field.addMove(player.nextMove(field.getField()), player));
			System.out.println(field);
			
			if (field.checkWin()) {
				System.out.println(player.getSymbol() + " wins!");
				break;
			}
			
			if (!field.hasEmptyCells()) {
				System.out.println("Tie!");
				break;
			}
		}
		
		System.out.println("Game over.\n");
    }
    
    private void delay(int msec) {
		try {
		    Thread.sleep(msec);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
    }
}