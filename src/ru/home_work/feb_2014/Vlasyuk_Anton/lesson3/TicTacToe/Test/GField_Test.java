package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.Test;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GField;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vlasyk on 29.04.14.
 */
public class GField_Test {
    GField gField;
    public static void main(String[] args) {
        GField_Test test = new GField_Test();
        test.go();
    }

    public void go() {
        Field field = new Field();
        gField = new GField(field);

        JFrame frame = new JFrame();
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JButton button = new JButton("repaintCell");
        button.addActionListener(new ButtonClick());

        frame.getContentPane().add(BorderLayout.CENTER, gField);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
    }

    class ButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           gField.gCells[0][0].selected = true;
            Player p1 = new PlayerHuman("O");
            gField.gCells[0][0].cell.setPlayer(p1);
            gField.repaint();
        }
    }
}
