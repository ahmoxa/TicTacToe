package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.GameMechanism;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;


public class GameMechanismConsole extends GameMechanism {

    public GameMechanismConsole(Field field, Player p1, Player p2) {
        super(field, p1, p2);
    }

    //Вывод на консоль результата игры
    public void PrintResult(){
        if (this.haveWin() != null) {
            System.out.println(this.haveWin().getSymbol() + " is a WINNER");
        } else {
            System.out.println("Tie!");
        }
    }

    @Override
    public void Start() {
        curPlayer =  new CurPlayer(p1,p2);
        curPlayer.setCurPlayer(p1);
        do {
            curPlayer.getCurPlayer().Move(field);
            for (int i = 0; i < field.getFIELD_SIZE(); i++) {
                for (int j = 0; j < field.getFIELD_SIZE(); j++) {
//                    this.gField.gCells[i][j].repaint();

                }
            }
            this.field.Display();
            curPlayer.getSwitchedCurPlayer();

        } while (!endGame());

        PrintResult();
           }


}
