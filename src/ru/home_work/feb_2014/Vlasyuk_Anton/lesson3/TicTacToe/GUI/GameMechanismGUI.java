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
            String msg;
            if (haveWin() instanceof Player) {
                msg = "Winner is Player: " + haveWin().getSymbol();
            }else {
                msg = "Tie";
            }
            GGame.getInstance().msgLabel.setText(msg);
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
            if (endGame()) {

            }
            else if (curPlayer.getCurPlayer() instanceof PlayerAI){
                this.turnAI();
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException ex) {

            }
        }
    }

    public void restart() {
        gField.ResetGField();
        GGame.getInstance().msgLabel.setText("START");

    }

}

