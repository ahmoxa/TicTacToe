package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.Forms;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GField;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;

import javax.swing.*;
import java.awt.*;


public class F_Game {



    public static void addComponentsToPane(Container pane, GField gField){
        JButton but = new JButton("Button1");
        JButton but2 = new JButton("Button2");
        JLabel lab = new JLabel("Label 1");
        JPanel pan = new JPanel();
        pan.add(but);
        pan.add(lab);

        pane.add(gField);
        pane.add(new BorderLayout().NORTH, pan);
        pane.add(new BorderLayout().SOUTH, but2);



    }

}
