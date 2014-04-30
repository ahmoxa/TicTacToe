package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.GameMechanism;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.*;

/**
 * Created by anton on 30.04.14.
 */
public class GameMechanismGUI extends GameMechanism {
    GField gField;


    public GameMechanismGUI(Field field, Player p1, Player p2, GField gField) {
        super(field, p1, p2);
        this.gField = gField;
    }



    @Override
    public void Start() {
        curPlayer =  new CurPlayer(p1,p2);
        curPlayer.setCurPlayer(p1);
        do {
            curPlayer.getCurPlayer().Move(field);
            for (int i = 0; i < field.getFIELD_SIZE(); i++) {
                for (int j = 0; j < field.getFIELD_SIZE(); j++) {
                    this.gField.gCells[i][j].repaint();
                }
            }
            this.field.Display();
            curPlayer.getSwitchedCurPlayer();

        } while (!endGame());

//        PrintResult();
    }
}

