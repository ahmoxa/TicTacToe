package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.*;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GGame  implements GPlayerHumanInterface {
    private Field field;
    private GField gField;
//    private Player player1 = new GPlayerHuman("X");
    private Player player1 = new PlayerAI("X");
//    private Player player2 = new GPlayerHuman("O");
    private Player player2 = new PlayerAI("O");
    private CurPlayer curPlayer;
    GameMechanismGUI game;
    JPanel menuPanel;


    public GGame() {
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);

        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(gField.Size() + 25, gField.Size() + 75);

        JMenuBar menuBar = new JMenuBar();
        JMenuItem menuItemFieldReset = new JMenuItem("Restart!");
        menuItemFieldReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gField.ResetGField();
                System.out.println(game.endGame());
            }
        });
        menuBar.add(menuItemFieldReset);
        frame.setJMenuBar(menuBar);

        menuPanel = new JPanel();
        JButton startButton = new JButton("START!");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                GO();
//                menuPanel.setVisible(false);
            }
        });
        menuPanel.add(startButton);

        frame.getContentPane().add(gField);
        frame.add(menuPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game = new GameMechanismGUI(gField,curPlayer);

    }

    @Override
    public void turnHuman(GCell gCell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman)) {
            return;
        }
        gCell.cell.setPlayer(curPlayer.getCurPlayer());
        game.AfterTurn();
    }

    public  void turnAI(Field field) {
        if (!(curPlayer.getCurPlayer() instanceof PlayerAI)) {
            return;
        }
        curPlayer.getCurPlayer().Move(field);
        game.AfterTurn();
    }

    public void GameProcces(Field field) {
        if (game.endGame()){
            return;
        }else if (curPlayer.getCurPlayer() instanceof PlayerAI){
            turnAI(field);
        }

    }

    public void GO() {
        while (true){
            GameProcces(field);
        }
    }


}

