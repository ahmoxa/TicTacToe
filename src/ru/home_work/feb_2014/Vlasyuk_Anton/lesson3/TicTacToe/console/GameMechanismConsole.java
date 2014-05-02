package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.GameMechanism;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;


public class GameMechanismConsole extends GameMechanism {

    public GameMechanismConsole(Field field,CurPlayer curPlayer) {
        super(field, curPlayer);
    }

    //Вывод на консоль результата игры
    public void PrintResult(){
        if (this.haveWin() != null) {
            System.out.println(this.haveWin().getSymbol() + " is a WINNER");
        } else {
            System.out.println("Tie!");
        }
    }


    public void Start() {
        do {
            curPlayer.getCurPlayer().Move(field);
            this.field.Display();
            curPlayer.getSwitchedCurPlayer();
        } while (!endGame());

        PrintResult();
    }


}
