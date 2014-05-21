package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.Forms;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GField;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;

import javax.swing.*;
import java.awt.*;


public class F_Game {


    static int frameSize = 512;




    public static void addComponentsToPane(Container pane, GField gField){
        JButton but = new JButton("Button 1");
        gField.add(but);
        pane.add(gField);


    }

}
