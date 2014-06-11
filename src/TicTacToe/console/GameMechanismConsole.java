package TicTacToe.console;

import TicTacToe.model.*;



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

    //Процесс игры
    public void Start() {
        do {
            curPlayer.getCurPlayer().Move(field);
            this.field.Display();
            curPlayer.getSwitchedCurPlayer();
        } while (!endGame());

        PrintResult();
    }


}
