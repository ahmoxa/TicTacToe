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


    public GGame() {
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);

        JFrame frame = new JFrame();
        frame.setSize(gField.Size() + 40, gField.Size() + 80);
        JButton button = new JButton("Restart!");
        button.addActionListener(new ButtonClicked());
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.getContentPane().add(button);
        frame.getContentPane().add(gField);
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

    class ButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gField.ResetGField();
            System.out.println(game.endGame());


        }
    }
}

