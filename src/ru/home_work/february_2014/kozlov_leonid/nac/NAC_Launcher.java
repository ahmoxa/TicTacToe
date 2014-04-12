package ru.home_work.february_2014.kozlov_leonid.nac;

import ru.home_work.february_2014.kozlov_leonid.nac.gui.*;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.*;

public class NAC_Launcher {

    private Player playerA;
    private Player playerB;
    private Field field;
    private Judge judge;

    private void initPlayers() {
        // Инициализируем первого игрока и назначаем в игре роль X
        if (Gui.out.menuBar.isAutoPlayerA()) {
            playerA = new PlayerAuto();
        } else {
            playerA = new PlayerGUI();
        }
        playerA.setPlayerX();

        // Инициализируем второго игрока и назначаем в игре роль O
        if (Gui.out.menuBar.isAutoPlayerB()) {
            playerB = new PlayerAuto();
        } else {
            playerB = new PlayerGUI();
        }
        playerB.setPlayerO();
    }

    private void initGameFlow() {
        // Инициализируем игровое поле
        field = new Field();
        Gui.out.graphicField.setCells(field);

        // Инициализируем арбитра, для управления игрой
        judge = new Judge(field, playerA, playerB);
    }

    private void gameStart() {

        // Запускаем бесконечный игровой цикл
        while (true) {

            System.out.println("-- Итерация игры в NAC!!! --");
            this.initPlayers(); // Инициализируем игроков
            this.initGameFlow(); // Инициализируем управление игрой

            while (true) {

                // Выводим поле
                System.out.println(field);

                // Проверяем на ничью
                if (!field.isEmpty()) {
                    System.out.println(field);
                    System.out.println("Победила дружба!!!");
                    Gui.out.waitRestart();
                    break;
                }

                // Запрашиваем у игрока, куда он хочет сходить
                Player nextPlayer = judge.getPlayer();
                Cell nextCell = nextPlayer.selectNextCell(judge);

                // В случае прерывания игры, выбор ячейки неопределён
                if (nextCell == null) break;

                // Делаем ход, по желанию игрока
                nextCell.makeMove(nextPlayer);
                Gui.out.graphicField.doRepaintCells();

                // Проверяем на выигрыш текущего игрока
                Line winLine = judge.getWinLine();
                if (winLine != null) {
                    System.out.println(field);
                    System.out.println("Выиграли " + nextPlayer + "!");
                    Gui.out.waitRestart();
                    break;
                }

                // Передаём ход другому игроку
                judge.switchPlayers();
            }
        }

    }

    public static void main(String[] args) {
        NAC_Launcher nac_launcher = new NAC_Launcher();
        nac_launcher.gameStart();
    }

}
