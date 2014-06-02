package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;

import javax.swing.*;

/**
 * Created by vlasyk on 02.06.14.
 */
public class MenuBar extends JMenuBar {
    private JMenu game;
    private JMenuItem restart;
    private JMenuItem exit;

    public MenuBar() {
        this.add(getGameMenu());
    }

    // Меню Игра
    private JMenu getGameMenu() {
        game = new JMenu("Игра");


        // Подменю Начать заново меню Игра
        restart = new JMenuItem("Начать заново");


        // Поменю Выход меню Игра
        exit = new JMenuItem("Выход");


        // Формирование меню Игра
        game.add(restart);
        game.addSeparator();
        game.add(exit);

        return game;
    }
}
