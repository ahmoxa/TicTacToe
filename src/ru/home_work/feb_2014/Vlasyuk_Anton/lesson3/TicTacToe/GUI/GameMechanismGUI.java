package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.GameMechanism;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.*;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anton on 30.04.14.
 */
public class GameMechanismGUI extends GameMechanism {
    GField gField;


    public GameMechanismGUI(GField gField, CurPlayer curPlayer) {
        super(gField.getField(), curPlayer);
        this.gField = gField;
    }

    public void AfterTurn () {
        gField.repaint();
        gField.getField().Display();
        System.out.println(this.endGame());
        if (endGame()) {
            System.out.println("Game END!");
        }
        curPlayer.getSwitchedCurPlayer();

    }


}

