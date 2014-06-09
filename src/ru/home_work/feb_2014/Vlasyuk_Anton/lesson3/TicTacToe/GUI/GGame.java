package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;




import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//TODO Запуск игры в выбранно режиме (PlayervsPlayer or PlayervsAI)

public final class GGame  implements GPlayerHumanInterface, Runnable {
    private static GGame instance = new GGame();

    private Field field;
    protected GField gField;
    MenuBar menu = new MenuBar();
    public static final String HUMAN = "Human";
    public static final String AI = "AI";
     Player player1;
//    private Player player1 = new GPlayerHuman("X");
//    private Player player1 = new PlayerAI("X");
     Player player2;
//    private Player player2 = new PlayerAI("O");
//    private Player player2 = new GPlayerHuman("O");

    private CurPlayer curPlayer;
    GameMechanismGUI game;
    Thread  gameThread;
    JLabel msgLabel;
    JFrame frame;


    private GGame() {
        player1 = new GPlayerHuman("X");
        player1.setName("Player_1");

        gameThread = new Thread(this);
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);
        game = new GameMechanismGUI(gField,curPlayer);
        frame = new JFrame("TicTacToe");
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

    public void setPlayer2(String type){
        System.out.println("--------SetPlayer2-----");
        if (type == HUMAN){
            player2 = new GPlayerHuman("O");
        }else if (type == AI) {
            player2 = new PlayerAI("O");
        }

        player2.setName("Player_2");

        System.out.println("type - " + type + " player2 " + player2.getClass());
    }


    public void showMsg(String msg){
        msgLabel.setText(msg);
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


