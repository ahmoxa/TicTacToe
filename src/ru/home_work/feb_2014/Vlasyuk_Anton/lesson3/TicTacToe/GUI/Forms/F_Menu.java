package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.Forms;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GGame;

import javax.swing.*;
import java.awt.*;



public class F_Menu extends JPanel{
    static String playerAI = "PlayerAI";
    static String playerHum = "GPlayerHuman";
    JButton startBut;
    JTextField playerTextField_1;
    JTextField playerTextField_2;
    ButtonGroup players_1;
    ButtonGroup players_2;


    public   F_Menu() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill   = GridBagConstraints.NONE;

        JLabel playerLabel_1 = new JLabel("Player 1");
        c.gridx = 0;
        c.gridy = 0;
        this.add(playerLabel_1, c);

        playerTextField_1 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        this.add(playerTextField_1, c);

        JLabel playerLabel_2 = new JLabel("Player 2");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        this.add(playerLabel_2, c);

        playerTextField_2 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 0, 0);
        this.add(playerTextField_2, c);


        JRadioButton playerAIBut_1 = new JRadioButton(playerAI);
        playerAIBut_1.setActionCommand(playerAI);
        JRadioButton playerHumanBut_1 = new JRadioButton(playerHum);
        playerHumanBut_1.setActionCommand(playerHum);
        players_1 = new ButtonGroup();
        players_1.add(playerAIBut_1);
        players_1.add(playerHumanBut_1);
        playerHumanBut_1.setSelected(true);



        JRadioButton playerAIBut_2 = new JRadioButton(playerAI);
        playerAIBut_2.setActionCommand(playerAI);
        JRadioButton playerHumanBut_2 = new JRadioButton(playerHum);
        playerHumanBut_2.setActionCommand(playerHum);
        players_2 = new ButtonGroup();
        players_2.add(playerAIBut_2);
        players_2.add(playerHumanBut_2);



        c.gridx = 2;
        c.gridy = 0;
        this.add(playerAIBut_1,c);
        c.gridx = 3;
        c.gridy = 0;
        this.add(playerHumanBut_1,c);

        c.gridx = 2;
        c.gridy = 1;
        this.add(playerAIBut_2,c);
        c.gridx = 3;
        c.gridy = 1;
        this.add(playerHumanBut_2,c);

        startBut = new JButton(GGame.GAME_PANEL);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.ipady = 40;
        c.gridwidth = 2;
        c.insets = new Insets(40, 5, 0, 0);
        this.add(startBut,c);
    }

    public JButton getStartBut() {
        return this.startBut;
    }

    public String getPlayerName_1(){
        return playerTextField_1.getText();
    }

    public String getPlayerName_2(){
        return playerTextField_2.getText();
    }

    public String getPlayerType_1(){
        return players_1.getSelection().getActionCommand();
    }

    public String getPlayerType_2(){
        return players_2.getSelection().getActionCommand();
    }


    }

