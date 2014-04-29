package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.Test;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GCell;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GCell_Test  {


    int x = 1;
    int y = 1;
    static Cell cell = new Cell();
    Player player = new PlayerHuman("X");
    static   GCell gcell;

    public void go() {
        int x = 1;
        int y = 1;
        cell = new Cell();
        Player player = new PlayerHuman("X");
        cell.setPlayer(player);
        gcell = new GCell(x,y,cell,player);
        gcell.selected = true;
        JButton button = new JButton("repaintCell");
        button.addActionListener(new ButtonClick());

        JFrame frame = new JFrame();
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.getContentPane().add(BorderLayout.CENTER, gcell);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
    }

    public static void main(String[] args) {
       GCell_Test test = new GCell_Test();
        test.go();
    }

    class ButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           cell.getPlayer().setSymbol("O");
           gcell.repaint();

        }
    }
}
