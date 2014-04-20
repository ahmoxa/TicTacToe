package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.GameMechanism;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Cell;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;

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
        GameMechanism game = new GameMechanism(gField,p1,p2);
        game.Start();

    }

    @Override
    public void turnHuman(Cell cell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman)) {
            return;
        }
            cell.setPlayer(curPlayer.getCurPlayer());
            gField.repaint();
    }
}

