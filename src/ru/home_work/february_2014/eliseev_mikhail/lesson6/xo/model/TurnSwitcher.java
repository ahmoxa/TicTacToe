package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model;

class TurnSwitcher {

	private Player[] players;
	private int curPlayerIndex;
	
	public TurnSwitcher(Player p1, Player p2) {
		players = new Player[]{p1, p2};
		shuffle();
	}
	
	public Player getCurPlayer() {
		return players[curPlayerIndex];
	}
	
	public void changePlayer() {
		curPlayerIndex = curPlayerIndex == 0 ? 1 : 0;
	}
	
	public void shuffle() {
		curPlayerIndex = (int)(Math.random() * 2); // 0 или 1
	}
	
	// index = 1|2; порядок такой же как в конструкторе
	public void changePlayer(Player p, int index) {
		players[index - 1] = p;
	}
}