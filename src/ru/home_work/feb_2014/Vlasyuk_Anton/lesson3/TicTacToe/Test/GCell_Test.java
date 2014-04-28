package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.Test;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GCell;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;

public class GCell_Test  {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        Cell cell = new Cell();
        Player player = new PlayerHuman("X");
        GCell gcell = new GCell(1,1,cell,player);
        JButton button = new JButton("repaintCell");
        JFrame frame = new JFrame();
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getContentPane().add(gcell);
        frame.getContentPane().add(button);
    }
}
