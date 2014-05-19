package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.*;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GGame  implements GPlayerHumanInterface, Runnable {
    private Field field;
    private GField gField;
//    private Player player1 = new GPlayerHuman("X");
    private Player player1 = new PlayerAI("X");
//    private Player player2 = new GPlayerHuman("O");
    private Player player2 = new PlayerAI("O");
    private CurPlayer curPlayer;
    GameMechanismGUI game;
    Thread  gameThread;


    final static String BUTTONPANEL = "MENU";
    final static String TEXTPANEL = "GAME";
    JPanel cards;

    public GGame() {
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);
        gameThread = new Thread(this);
        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(gField.Size() + 25, gField.Size() + 75);
        initialization();
    }

//    public void initialization() {
//        //FRAME
//        JFrame frame = new JFrame("TicTacToe");
//        frame.setSize(gField.Size() + 25, gField.Size() + 75);
//
//        //MENUBAR
//        JMenuBar menuBar = new JMenuBar();
//        JMenuItem menuItemFieldReset = new JMenuItem("Restart!");
//        menuItemFieldReset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                gField.ResetGField();
//                System.out.println(game.endGame());
//            }
//        });
//        JMenuItem menuItemStart = new JMenuItem("START");
//        menuItemStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(Thread.State.RUNNABLE.compareTo(gameThread.getState()));
//                if ((Thread.State.RUNNABLE.compareTo(gameThread.getState())) == 1){
//                    gameThread.start();
//                }else return;
//
//                System.out.println(Thread.State.RUNNABLE.compareTo(gameThread.getState()));
//
//            }
//        });
//        menuBar.add(menuItemFieldReset);
//        menuBar.add(menuItemStart);
//        frame.setJMenuBar(menuBar);
//
//        //GFIELD
//        frame.getContentPane().add(gField);
//
//
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        game = new GameMechanismGUI(gField,curPlayer);
//    }

    public void initialization(){
        class buttonPressed implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
//                System.out.println(e.paramString().matches("GAME"));
                cl.show(cards, TEXTPANEL);
            }
        }
        JFrame frame = new JFrame("TiCtAcToE");
        frame.setSize(800,800);

        JPanel menu = new JPanel();
        JLabel menuLab = new JLabel("CARD1");
        JButton menuBut = new JButton("GAME");
        menuBut.addActionListener(new buttonPressed());
        menu.add(menuLab);
        menu.add(menuBut);

        JPanel game = new JPanel();
        JLabel gameLab = new JLabel("CARD2");
        JButton gameBut = new JButton("MENU");
        gameBut.addActionListener(new buttonPressed());
        game.add(gameLab);
        game.add(gameBut);

        cards = new JPanel(new CardLayout());
        cards.add(menu, BUTTONPANEL);
        cards.add(game, TEXTPANEL);




        frame.getContentPane().add(cards);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void turnHuman(GCell gCell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman)) {
            return;
        }
        gCell.cell.setPlayer(curPlayer.getCurPlayer());
        game.AfterTurn();
    }

    @Override
    public void run() {
        game.Start();
    }
}

