package ru.home_work.february_2014.kozlov_leonid.nac.logic;

import java.util.ArrayList;

public class Judge {

    private Field field; // Игровое поле, подконтрольное арбитру
    private ArrayList<Line> lines = new ArrayList<Line>(); // Коллекция линий поля
    private Player playerA; // Игрок A
    private Player playerB; // Игрок B
    private Player player;  // Текущий игрок

    public Judge(Field field, Player playerA, Player playerB) {
        // Сохраняем игровое поле в арбитре
        this.field = field;
        // Инициализируем коллекцию линий
        for (int j = 0; j < 8; j++) {
            Line l = new Line();
            switch (j) {
                case 0: l.add(field.getCell(0)); l.add(field.getCell(1)); l.add(field.getCell(2)); break;
                case 1: l.add(field.getCell(3)); l.add(field.getCell(4)); l.add(field.getCell(5)); break;
                case 2: l.add(field.getCell(6)); l.add(field.getCell(7)); l.add(field.getCell(8)); break;
                case 3: l.add(field.getCell(0)); l.add(field.getCell(3)); l.add(field.getCell(6)); break;
                case 4: l.add(field.getCell(1)); l.add(field.getCell(4)); l.add(field.getCell(7)); break;
                case 5: l.add(field.getCell(2)); l.add(field.getCell(5)); l.add(field.getCell(8)); break;
                case 6: l.add(field.getCell(0)); l.add(field.getCell(4)); l.add(field.getCell(8)); break;
                case 7: l.add(field.getCell(2)); l.add(field.getCell(4)); l.add(field.getCell(6)); break;
            }
            lines.add(l);
        }
        // Сохраняем игроков
        this.playerA = playerA;
        this.playerB = playerB;
        // Определяем текущего игрока
        player = playerA;
    }


    public Field getField() {
        return field;
    }

    public Line getWinLine() {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            if (line.isWinLine(player)) return line;
        }
        return null;
    }

    public void goWeighting() {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            line.goWeighting(player);
        }
    }

    public void switchPlayers() {
        if (player == playerA) {
            player = playerB;
        } else {
            player = playerA;
        }
    }

    public Player getPlayer() {
        return player;
    }
}
