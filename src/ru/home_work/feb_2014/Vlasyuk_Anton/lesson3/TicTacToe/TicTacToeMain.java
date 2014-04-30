package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.GameMechanismConsole;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;

public class TicTacToeMain {

    public static void main(String[] args) {
        Field myField = new Field();
        Player p1 = new PlayerHuman("X");
        Player p2 = new PlayerHuman("O");
        GameMechanism game = new GameMechanismConsole(myField,p1,p2);
        game.Start();




    }
}
