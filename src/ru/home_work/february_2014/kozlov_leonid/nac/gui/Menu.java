package ru.home_work.february_2014.kozlov_leonid.nac.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {


    private JMenu game;
    private JMenuItem restart;
    private JMenuItem exit;
    private JMenu playerA;
    private JRadioButtonMenuItem playerAGUI;
    private JRadioButtonMenuItem playerAAuto;
    private JMenu playerB;
    private JRadioButtonMenuItem playerBGUI;
    private JRadioButtonMenuItem playerBAuto;

    private boolean restartFlag = false;

    public Menu() {
        this.add(getGameMenu());
        this.add(getPlayerAMenu());
        this.add(getPlayerBMenu());
    }

    // Меню Игра
    private JMenu getGameMenu() {
        game = new JMenu("Игра");
        game.addActionListener(this);

        // Подменю Начать заново меню Игра
        restart = new JMenuItem("Начать заново");
        restart.addActionListener(this);

        // Поменю Выход меню Игра
        exit = new JMenuItem("Выход");
        exit.addActionListener(this);

        // Формирование меню Игра
        game.add(restart);
        game.addSeparator();
        game.add(exit);

        return game;
    }


    // Меню Игрок 1
    private JMenu getPlayerAMenu() {
        playerA = new JMenu("Игрок 1");
        playerA.addActionListener(this);

        // Подменю Начать заново меню Игра
        playerAGUI = new JRadioButtonMenuItem("Человек");
        playerAGUI.setSelected(true);
        playerAGUI.addActionListener(this);

        // Поменю Выход меню Игра
        playerAAuto = new JRadioButtonMenuItem("Компьютер");
        playerAAuto.setSelected(false);
        playerAAuto.addActionListener(this);

        // Формирование меню Игра
        playerA.add(playerAGUI);
        playerA.add(playerAAuto);

        return playerA;
    }

    // Меню Игрок 2
    private JMenu getPlayerBMenu() {
        playerB = new JMenu("Игрок 2");
        playerB.addActionListener(this);

        // Подменю Начать заново меню Игра
        playerBGUI = new JRadioButtonMenuItem("Человек");
        playerBGUI.setSelected(true);
        playerBGUI.addActionListener(this);

        // Поменю Выход меню Игра
        playerBAuto = new JRadioButtonMenuItem("Компьютер");
        playerBAuto.setSelected(false);
        playerBAuto.addActionListener(this);

        // Формирование меню Игра
        playerB.add(playerBGUI);
        playerB.add(playerBAuto);

        return playerB;
    }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Object menuItem = actionEvent.getSource();

        // Проверяем переключатели человек-компьютер
        if (menuItem instanceof JRadioButtonMenuItem) {
            if (menuItem.equals(playerAGUI)) playerAAuto.setSelected(false);
            if (menuItem.equals(playerAAuto)) playerAGUI.setSelected(false);
            if (menuItem.equals(playerBGUI)) playerBAuto.setSelected(false);
            if (menuItem.equals(playerBAuto)) playerBGUI.setSelected(false);
            restartFlag = true;
        }

        // Проверяем пункты меню
        if (menuItem.equals(exit)) System.exit(0);
        if (menuItem.equals(restart)) restartFlag = true;
    }

    public boolean isRestart() {
        boolean res = restartFlag;
        restartFlag = false;
        return res;
    }

    public boolean isAutoPlayerA() {
        return playerAAuto.isSelected();
    }

    public boolean isAutoPlayerB() {
        return playerBAuto.isSelected();
    }

}
