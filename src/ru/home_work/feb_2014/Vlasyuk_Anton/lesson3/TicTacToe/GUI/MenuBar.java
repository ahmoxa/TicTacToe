package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vlasyk on 02.06.14.
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private JMenu game;
    private JMenuItem start;
    private JMenuItem restart;
    private JMenuItem exit;


    public MenuBar() {
        this.add(getGameMenu());
    }

    // Меню Игра
    private JMenu getGameMenu() {
        game = new JMenu("Игра");

        // Подменю Начать Игра
        start = new JMenuItem("Начать");
        start.addActionListener(this);

        // Подменю Начать Заново меню Игра
        restart = new JMenuItem("Заново");
        restart.addActionListener(this);

        // Поменю Выход меню Игра
        exit = new JMenuItem("Выход");
        exit.addActionListener(this);


        // Формирование меню Игра
        game.add(start);
        game.addSeparator();
        game.add(restart);
        game.addSeparator();
        game.add(exit);

        return game;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object menuItem = e.getSource();

        if (menuItem.equals(start)) {
            Object[] possibilities = {"Player vs Player", "Player vs AI"};
            String s = (String)JOptionPane.showInputDialog(GGame.getInstance().frame,
                                                           "Choose game type...",
                                                            "Customized Dialog",
                                                            JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                            possibilities,
                                                            "Player vs AI");
            if (s == "Player vs Player") GGame.getInstance().setPlayer2(GGame.HUMAN);
            if (s == "Player vs AI") GGame.getInstance().setPlayer2(GGame.AI);
            System.out.println("GGAME PLAYER_1 - " + GGame.getInstance().player1);
            System.out.println("GGAME PLAYER_2 - " + GGame.getInstance().player2);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if (!GGame.getInstance().gameThread.isAlive()){
                GGame.getInstance().msgLabel.setText("START");
                GGame.getInstance().gameThread.start();
            }
        }else if (menuItem.equals(restart)){
            GGame.getInstance().game.restart();
        }
        else if (menuItem.equals(exit)) System.exit(0);

    }
}
