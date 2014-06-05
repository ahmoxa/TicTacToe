package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;




import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class GGame  implements GPlayerHumanInterface, Runnable {
    private static GGame instance = new GGame();

    private Field field;
    protected GField gField;
    MenuBar menu = new MenuBar();
//    private Player player1 = new GPlayerHuman("X");
    private Player player1 = new GPlayerHuman("X");
//    private Player player2 = new PlayerAI("O");
    private Player player2 = new GPlayerHuman("O");

    private CurPlayer curPlayer;
    GameMechanismGUI game;
    Thread  gameThread;
    JLabel msgLabel;


    private GGame() {
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);
        gameThread = new Thread(this);
        game = new GameMechanismGUI(gField,curPlayer);
        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(gField.Size() + 10, gField.Size() + 50);

        msgLabel = new JLabel();
        msgLabel.setHorizontalAlignment(JLabel.CENTER);
        msgLabel.setVerticalAlignment(JLabel.CENTER);
        msgLabel.setSize(612, 30);


        gField.add(msgLabel);
        frame.getContentPane().add(gField);
        frame.setJMenuBar(menu);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    public static GGame getInstance() {
        return instance;
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


