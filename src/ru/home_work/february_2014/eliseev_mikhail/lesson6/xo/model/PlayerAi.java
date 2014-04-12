package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model;

public class PlayerAi extends Player {

	protected Cell[][] field;
 	
 	public PlayerAi(char symbol, String name) {
        super(symbol, name);
    }
    
	@Override
	public FieldPos nextMove(Cell[][] gameField) {
	
		field = gameField;
		
		int r = 0;
		
		// 1. если есть возможность сделать "тройку" и выиграть - делаем
		
		if (_headsOrTails()) { // бывает, подтупливаем и не "замечаем выигрышного хода", но не слишком часто
			r = _moveWin();
		}
		
		// 2. если у противника есть "двойка" - блокируем ее
		
		if (r == 0 || _headsOrTails() == _headsOrTails()) { // иногда, когда у нас уже есть выигрышиный ход, игнорируем его и, вместо этого, "закрываем" двойку соперника - смотрится очень "почеловечески"
			r = _moveDefence();
		}
		
		// 3. иначе делаем другой ход.
		
		if (r == 0) {
			r = _move();
		}
		
		return FieldPos.num2pos(r);
	}
	
	protected int _move() {
		if (_headsOrTails()) {
			return _moveOtherCanonical(); // приоритет: центр, углы, остальные ячейки
		}
		return _randomFreeCell(); // случайная из свободных
	}
	
	// "добиваем", если есть возможность
	protected int _moveWin() {
		return _searchTrio(true);
	}
	
	// "блокируем", если есть что
	protected int _moveDefence() {		
		return _searchTrio(false);
	}
	
	protected int _moveOtherCanonical() {
		int r = _center(); // центр
		
		if (r == 0) {
			r = _randomFreeCorner(); // один из углов
		}
		
		if (r == 0) {
			r = _randomFreeOtherCell(); // не угол и не центр
		}
		
		return r;
	}
	
	// ищет потенциальные "тройки"
	protected int _searchTrio(boolean lookingForOwnCells) {
	
		// проверяем строки
		for (int y = 0; y < Field.SIZE; y++) {
			int sum = 0, r = 0;
			for (int x = 0; x < Field.SIZE; x++) {
				Player p = field[y][x].getPlayer();
				if (p == null) {
					r = FieldPos.pos2num(y, x);
				} else {
					if ((lookingForOwnCells && p == this) || (!lookingForOwnCells && p != this)) {
						++sum;
					}
				}
			}
			if (sum == Field.SIZE - 1 && r != 0) {
				return r;
			}
		}
		
		// ... столбцы
		for (int x = 0; x < Field.SIZE; x++) {
			int sum = 0, r = 0;
			for (int y = 0; y < Field.SIZE; y++) {
				Player p = field[y][x].getPlayer();
				if (p == null) {
					r = FieldPos.pos2num(y, x);
				} else {
					if ((lookingForOwnCells && p == this) || (!lookingForOwnCells && p != this)) {
						++sum;
					}
				}
			}
			if (sum == Field.SIZE - 1 && r != 0) {
				return r;
			}
		}
		
		// ... диагонали
		
		int r = 0, sum = 0;
		for (int i = 0; i < Field.SIZE; i++) {
			Player p = field[i][i].getPlayer();
			if (p == null) {
				r = FieldPos.pos2num(i, i);
			} else {
				if ((lookingForOwnCells && p == this) || (!lookingForOwnCells && p != this)) {
					++sum;
				}
			}
		}
		if (sum == Field.SIZE - 1 && r != 0) {
			return r;
		}
		
		r = sum = 0;
		for (int y = 0, x = Field.SIZE - 1; y < Field.SIZE; y++, x--) {
			Player p = field[y][x].getPlayer();
			if (p == null) {
				r = FieldPos.pos2num(y, x);
			} else {
				if ((lookingForOwnCells && p == this) || (!lookingForOwnCells && p != this)) {
					++sum;
				}
			}
		}
		if (sum == Field.SIZE - 1 && r != 0) {
			return r;
		}
		
		return 0;
	}
	
	// возвращает центр или 0
	// note: реализация этого метода "заточена" под поле 3 x 3; переписать, если будут ипользоваться поля других размеров
	protected int _center() {
		if (field[1][1].getPlayer() == null) {
			 return 5; 
		}
		return 0;
	}
	
	// возвращает случайный свободный угол или 0
	protected int _randomFreeCorner() {
		int[] emptyCells = new int[4];
		int i = 0;
		
		for (int y = 0; y < Field.SIZE; y++) {
			for (int x = 0; x < Field.SIZE; x++) {
				if (((x == 0 || x == Field.SIZE - 1) && (y == 0 || y == Field.SIZE - 1))) {
					if (field[y][x].getPlayer() == null) {
						emptyCells[i++] = FieldPos.pos2num(y, x);
					}
				}
			}
		}
		
		return _randomItemFromArray(emptyCells, i);
	}
	
	// возвращает случайную свободную "другую" клетку (не центр и не угол) или 0
	// note: реализация этого метода "заточена" под поле 3 x 3; переписать, если будут ипользоваться поля других размеров
	protected int _randomFreeOtherCell() {
		int[] emptyCells = new int[4];
		int i = 0;
		
		for (int y = 0; y < Field.SIZE; y++) {
			for (int x = 0; x < Field.SIZE; x++) {
				if ((x == 1 || y == 1) && x != y) {
					if (field[y][x].getPlayer() == null) {
						emptyCells[i++] = FieldPos.pos2num(y, x);
					}	
				}
			}
		}
		
		return _randomItemFromArray(emptyCells, i);
	}
	
	// возвращает номер случайной свободной клетки
	protected int _randomFreeCell() {
		int[] emptyCells = new int[Field.SIZE * Field.SIZE];
		int i = 0;
		
		for (int y = 0; y < Field.SIZE; y++) {
			for (int x = 0; x < Field.SIZE; x++) {
				if (field[y][x].getPlayer() == null) {
					emptyCells[i++] = FieldPos.pos2num(y, x);
				}		
			}
		}
		
		return _randomItemFromArray(emptyCells, i);
	}
	
	protected int _randomItemFromArray(int[] arr, int count) {
		if (count > 0) {
			return count == 1 ? arr[0] : arr[(int)(Math.random() * count)];
		}
		return 0;
	}
	
	// подбросим монетку
	protected boolean _headsOrTails() {
		int x = (int)(Math.random() * 2); // 0 | 1
		if (x != 0) {
			return true;
		}
		return false;
	}
}