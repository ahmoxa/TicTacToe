package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

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
        if (endGame()) {
            System.out.println("Game END!");
        }
        curPlayer.getSwitchedCurPlayer();
    }

    public  void turnAI() {
        if (!(curPlayer.getCurPlayer() instanceof PlayerAI)) {
            return;
        }
        curPlayer.getCurPlayer().Move(gField.getField());
        AfterTurn();
    }

    public void Start() {
        while (true) {
            if (this.endGame()){
                return;
            }else if (curPlayer.getCurPlayer() instanceof PlayerAI){
                this.turnAI();
            }
            try{
                Thread.sleep(5);
            }catch (InterruptedException ex) {

            }
        }
    }

}

