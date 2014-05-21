package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.Forms;

import javax.swing.*;
import java.awt.*;



public class F_Menu {
    static final int frameSize = 512;
    static String playerAI = "PlayerAI";
    static String playerHum = "GPlayerHuman";

    public static void addComponentsToPane(Container pane) {

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill   = GridBagConstraints.NONE;

        JLabel playerLabel_1 = new JLabel("Player 1");
        c.gridx = 0;
        c.gridy = 0;
        pane.add(playerLabel_1, c);

        JTextField playerTextField_1 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        pane.add(playerTextField_1, c);

        JLabel playerLabel_2 = new JLabel("Player 2");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        pane.add(playerLabel_2, c);

        JTextField playerTextField_2 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 0, 0);
        pane.add(playerTextField_2, c);


        JRadioButton playerAIBut_1 = new JRadioButton(playerAI);
        playerAIBut_1.setActionCommand(playerAI);
        JRadioButton playerHumanBut_1 = new JRadioButton(playerHum);
        playerHumanBut_1.setActionCommand(playerHum);
        ButtonGroup players_1 = new ButtonGroup();
        players_1.add(playerAIBut_1);
        players_1.add(playerHumanBut_1);

        JRadioButton playerAIBut_2 = new JRadioButton(playerAI);
        playerAIBut_2.setActionCommand(playerAI);
        JRadioButton playerHumanBut_2 = new JRadioButton(playerHum);
        playerHumanBut_2.setActionCommand(playerHum);
        ButtonGroup players_2 = new ButtonGroup();
        players_2.add(playerAIBut_2);
        players_2.add(playerHumanBut_2);



        c.gridx = 2;
        c.gridy = 0;
        pane.add(playerAIBut_1,c);
        c.gridx = 3;
        c.gridy = 0;
        pane.add(playerHumanBut_1,c);

        c.gridx = 2;
        c.gridy = 1;
        pane.add(playerAIBut_2,c);
        c.gridx = 3;
        c.gridy = 1;
        pane.add(playerHumanBut_2,c);

        JButton startBut = new JButton("START");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.ipady = 40;
        c.gridwidth = 2;
        c.insets = new Insets(40, 5, 0, 0);
        pane.add(startBut,c);
    }

    public static void main(String[] args) {
            // Создание окна
            JFrame frame = new JFrame("GridBagLayoutDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Установить панель содержания
            addComponentsToPane(frame.getContentPane());



            // Показать окно
            frame.setSize(frameSize + 25, frameSize + 75);
            frame.setVisible(true);
        }
    }

