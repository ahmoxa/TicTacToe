package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;



import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.Forms.F_Menu;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GGame  implements GPlayerHumanInterface, Runnable {
    public static final String MENU_PANEL = "Menu";
    public static final String GAME_PANEL = "Game";
    private Field field;
    private GField gField;
//    private Player player1 = new GPlayerHuman("X");
    private Player player1 = new PlayerAI("X");
//    private Player player2 = new PlayerAI("O");
    private Player player2 = new GPlayerHuman("O");

    private CurPlayer curPlayer;
    GameMechanismGUI game;
    Thread  gameThread;


    public GGame() {
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);
        gameThread = new Thread(this);
        game = new GameMechanismGUI(gField,curPlayer);
        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(gField.Size() + 10, gField.Size() + 50);

        JLabel label = new JLabel("Label1");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setSize(612, 30);

        JButton buttonMenu = new JButton("Start");
        buttonMenu.setSize(100,30);
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameThread.isAlive()){
                    gameThread.start();
                }
            }
        });

        gField.add(label);
        gField.add(buttonMenu);
        frame.getContentPane().add(gField);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    @Override
    public void turnHuman(GCell gCell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman)) {
            return;
        }
        gCell.cell.setPlayer(curPlayer.getCurPlayer());
        game.AfterTurn();
    }

    @Override
    public void run() {
        game.Start();
    }


    }


