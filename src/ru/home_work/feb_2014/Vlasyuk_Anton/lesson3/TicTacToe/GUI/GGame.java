package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.*;

import javax.swing.*;

public class GGame {
    public static void main(String[] args) {
        Field field = new Field();
        GField gField = new GField(field);
        JFrame frame = new JFrame();
        frame.setSize(gField.SIZE+40,gField.SIZE+40);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(gField);


        Player p1 = new PlayerHuman("X");
        Player p2 = new PlayerHuman("O");
        GameMechanism game = new GameMechanism(gField,p1,p2);
        game.Start();
    }
}

