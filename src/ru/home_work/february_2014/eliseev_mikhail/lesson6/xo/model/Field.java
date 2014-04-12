package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model;

public class Field {

    public static final int SIZE = 3;
    
    private TurnSwitcher turnSwitcher;
	private Cell[][] cells = new Cell[SIZE][SIZE];
	private boolean isGameOver;
    
    public Field(Player p1, Player p2) {
    	turnSwitcher = new TurnSwitcher(p1, p2);
    	for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    
    public void reset() {
    	turnSwitcher.shuffle();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].setPlayer(null);
            }
        }
	    isGameOver = false;
    }
    
    public Player getCurPlayer() {
	    return turnSwitcher.getCurPlayer();
    }
    
	public void changePlayer(Player p, int index) {
		turnSwitcher.changePlayer(p, index);
	}
    
    public Cell[][] getField() {
	    return cells;
    }
    
    public boolean isGameOver() {
	    return isGameOver;
    }

    public boolean addMove(FieldPos pos, Player player) {
    	if (isGameOver) {
	    	return false;
    	}
    	if (cells[pos.y][pos.x].getPlayer() == null) {
    		cells[pos.y][pos.x].setPlayer(player);
    		if (hasEmptyCells() && !checkWin()) {
	    		turnSwitcher.changePlayer();
    		} else {
	    		isGameOver = true;
    		}
	    	return true;
    	}
        return false;
    }
    
    public boolean hasEmptyCells() {
	    for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if (cells[i][j].getPlayer() == null) {
	                return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkWin() {
    	Player[] line = new Player[SIZE];
    	Player p = null;
    	
    	// проверяем строки
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if ((line[j] = p = cells[i][j].getPlayer()) == null) {
					break;
				}
			}
			if (p != null && _isWinLine(line)) {
				return true;
			}
		}
		
		// ... столбцы
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if ((line[j] = p = cells[j][i].getPlayer()) == null) {
					break;
				}
			}
			if (p != null && _isWinLine(line)) {
				return true;
			}
		}
		
		// ... диагонали
		
		for (int i = 0; i < SIZE; i++) {
			if ((line[i] = p = cells[i][i].getPlayer()) == null) {
				break;
			}
		}
		if (p != null && _isWinLine(line)) {
			return true;
		}
		
		for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
			if ((line[i] = p = cells[i][j].getPlayer()) == null) {
				break;
			}
		}
		if (p != null && _isWinLine(line)) {
			return true;
		}
		
	    return false;
    }
    
    private boolean _isWinLine(Player[] line) {
    	Player p = line[0];
    	for (int i = 1; i < line.length; i++) {
	    	if (p != line[i]) {
		    	return false;
	    	}
    	}
	    return true;
    }
	
	@Override
    public String toString() {
    	String r = "\n";
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                r += cells[y][x].toString();
            }
            r += "\n";
        }
        return r;
    }
}