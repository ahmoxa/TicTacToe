package TicTacToe.GUI;

import TicTacToe.model.*;


public class GameMechanismGUI extends GameMechanism {

    GField gField;

    public GameMechanismGUI(GField gField, CurPlayer curPlayer) {
        super(gField.getField(), curPlayer);
        this.gField = gField;
    }

    public void AfterTurn () {
        gField.repaint();
        gField.getField().Display();
        curPlayer.getSwitchedCurPlayer();
        showMsgCurPlayer();
        if (endGame()) {
            String msg;
            if (haveWin() != null) {
                msg = "Winner is : " + haveWin().getName() + " " +  haveWin().getSymbol();
                haveWin().incWinCount();
                GGame.getInstance().updateScore();

            }else {
                msg = "Tie";
            }
            msg = "<html><font size = \"6\">" + msg + "</font></html>";
            GGame.showMsg(msg);
        }
    }

    public  void turnAI() {
        if (!(curPlayer.getCurPlayer() instanceof PlayerAI)) {
            return;
        }
        curPlayer.getCurPlayer().Move(gField.getField());
        AfterTurn();
    }

    public void showMsgCurPlayer(){
        String msg = "Turn is " + curPlayer.getCurPlayer().getName() + " " + curPlayer.getCurPlayer().getSymbol();
        GGame.showMsg("<html><font size = \"5\"> Turn is   "  + curPlayer.getCurPlayer().getName() + " " + curPlayer.getCurPlayer().getSymbol() +" </font></html>");
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
        showMsgCurPlayer();
    }

}

