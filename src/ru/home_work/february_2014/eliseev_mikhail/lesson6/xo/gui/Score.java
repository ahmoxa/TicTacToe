package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.gui;

import java.util.*;

class Score {

	private Map<String, Integer> score;
	
	public Score(char player1Symbol, char player2Symbol) {
		score = new HashMap<String, Integer>();
		score.put(Character.toString(player1Symbol), 0);
		score.put(Character.toString(player2Symbol), 0);
	}
	
	public int getScore(char playerSymbol) {
		return (int)score.get(Character.toString(playerSymbol));
	}
	
	public void increment(char playerSymbol) {
		int x = getScore(playerSymbol);
		score.put(Character.toString(playerSymbol), ++x);
	}
	
	public void resetScore() {
		for (String playerSymbol : score.keySet()) {
			score.put(playerSymbol, 0);
		}
	}
}