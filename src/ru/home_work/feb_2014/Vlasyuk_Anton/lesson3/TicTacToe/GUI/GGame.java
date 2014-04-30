package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.*;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;

public class GGame implements GPlayerHumanInterface{
    private Field field;
    private GField gField;
    private Player player1 = new GPlayerHuman("X");
    private Player player2;
    private CurPlayer curPlayer;



    public GGame() {
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);

        JFrame frame = new JFrame();
        frame.setSize(gField.SIZE+40,gField.SIZE+40);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(gField);


        Player p1 = new PlayerHuman("X");
        Player p2 = new PlayerHuman("O");
        GameMechanism game = new GameMechanismGUI(gField.field,p1,p2,gField);
        game.Start();

    }

    @Override
    public void turnHuman(GCell gCell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman)) {
            return;
        }
            gCell.cell.setPlayer(curPlayer.getCurPlayer());
            gCell.selected = true;
            gField.repaint();
            curPlayer.getSwitchedCurPlayer();
    }
}

