package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.*;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;

public class GGame  implements GPlayerHumanInterface {
    private Field field;
    private GField gField;
    private Player player1 = new PlayerAI("X");
    private Player player2 = new GPlayerHuman("O");
    private CurPlayer curPlayer;
    GameMechanismGUI game;



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
        game = new GameMechanismGUI(gField,curPlayer);
    }

    @Override
    public void turnHuman(GCell gCell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman)) {
            return;
        }
            gCell.cell.setPlayer(curPlayer.getCurPlayer());
            gCell.selected = true;
            game.AfterTurn();

    }
}

