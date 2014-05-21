package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.Forms.F_Game;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.CurPlayer;
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
        JButton but = new JButton("Button1");
        JButton but2 = new JButton("Button2");
        JLabel lab = new JLabel("Label 1");
        JPanel pan = new JPanel();
        pan.add(but);
        pan.add(lab);
//        initialization();
        frame.getContentPane().add(gField);
        frame.getContentPane().add(new BorderLayout().NORTH, pan);
        frame.getContentPane().add(new BorderLayout().SOUTH,but2 );

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


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

//    public void initialization(){
//        class buttonPressed implements ActionListener {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout)(cards.getLayout());
//                JButton but = (JButton)e.getSource();
//                System.out.println(but.getText());
//                cl.show(cards, but.getText());
//            }
//        }
//        JFrame frame = new JFrame("TiCtAcToE");
//        frame.setSize(800,800);
//
//        JPanel menu = new JPanel();
//        JLabel menuLab = new JLabel("CARD1");
//        JButton menuBut = new JButton("GAME");
//        menuBut.addActionListener(new buttonPressed());
//        menu.add(menuLab);
//        menu.add(menuBut);
//
//        JPanel game = new JPanel();
//        JLabel gameLab = new JLabel("CARD2");
//        JButton gameBut = new JButton("MENU");
//        gameBut.addActionListener(new buttonPressed());
//        game.add(gameLab);
//        game.add(gameBut);
//
//        cards = new JPanel(new CardLayout());
//        cards.add(menu, BUTTONPANEL);
//        cards.add(game, TEXTPANEL);
//
//
//
//
//        frame.getContentPane().add(cards);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }

//    public void initialization() {
         //FRAME
//        JFrame frame = new JFrame("TicTacToe");
//        frame.setSize(gField.Size() + 25, gField.Size() + 75);
//          frame.setSize(1024,1024);
//        JPanel menu = new JPanel();
//        JLabel menuLab = new JLabel("CARD1");
//        JButton menuBut = new JButton("GAME");
//        menuBut.addActionListener(new buttonPressed());
//        menu.add(menuLab);
//        menu.add(menuBut);
//
//        JPanel game = new JPanel();
//        JLabel gameLab = new JLabel("CARD2");
//        JButton gameBut = new JButton("MENU");
//        gameBut.addActionListener(new buttonPressed());
//        game.add(gameLab);
//        game.add(gameBut);
//
//        cards = new JPanel(new CardLayout());
//        cards.add(menu, BUTTONPANEL);
//        cards.add(game, TEXTPANEL);

//        JButton butStart = new JButton("Start");
//        butStart.addActionListener(new ActionListener() {
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
//
//        class buttonPressed implements ActionListener {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout)(cards.getLayout());
//                JButton but = (JButton)e.getSource();
//                cl.show(cards, but.getText());
//            }
//        }
//
//        // Card Game
//        JButton butMenu = new JButton("Menu");
//        butMenu.addActionListener(new buttonPressed());
//
//        JPanel panelGame = new JPanel(new BorderLayout());
//        panelGame.add(BorderLayout.CENTER, gField);
//        panelGame.add(BorderLayout.SOUTH, butMenu);
//
//        //Card Menu
//        JButton butGame = new JButton("Game");
//        butGame.addActionListener(new buttonPressed());
//
//
//        JPanel panelMenu = new JPanel();
//        panelMenu.add(new JLabel("Menu"));
//        panelMenu.add(butGame);
//
//        cards = new JPanel(new CardLayout());
//        cards.add(panelMenu, "Menu");
//        cards.add(panelGame, "Game");
//        frame.setContentPane(cards);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        game = new GameMechanismGUI(gField,curPlayer);


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

