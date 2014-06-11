package TicTacToe;


import TicTacToe.console.*;
import TicTacToe.model.*;


public class TicTacToeMain {

    public static void main(String[] args) {
        Field myField = new Field();
        Player p1 = new PlayerHuman("X");
        Player p2 = new PlayerHuman("O");
        CurPlayer curPlayer = new CurPlayer(p1,p2);
        GameMechanismConsole game = new GameMechanismConsole(myField,curPlayer);
        game.Start();




    }
}
