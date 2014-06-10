package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;




import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.PlayerHuman;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.CurPlayer;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public final class GGame  implements GPlayerHumanInterface, Runnable {
    private static GGame instance = new GGame();

    private Thread gameThread;
    private boolean gameThreadRunning = false;


    private Field field;
    protected GField gField;
    MenuBar menu = new MenuBar();
    public static final String HUMAN = "Human";
    public static final String AI = "AI";
    Player player1;
    Player player2;
    private CurPlayer curPlayer;
    GameMechanismGUI game;
    static JLabel msgLabel;
    JLabel scoreLabel;
    JFrame frame;


    private GGame() {
        player1 = new GPlayerHuman("X");
        player1.setName("Player_1");

        player2 = new PlayerAI("X");
        player2.setName("Player_2");

        gameThread = new Thread(this);
        field = new Field();
        gField = new GField(field, this);
        curPlayer = new CurPlayer(player1, player2);
        game = new GameMechanismGUI(gField,curPlayer);
        frame = new JFrame("TicTacToe");
        frame.setSize(gField.Size() + 10, gField.Size() + 50);

        msgLabel = new JLabel();
        msgLabel.setHorizontalAlignment(JLabel.CENTER);
        msgLabel.setVerticalAlignment(JLabel.CENTER);
        msgLabel.setSize(612, 30);

        scoreLabel = new JLabel();
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setSize(612, 50);
        scoreLabel.setLocation(0,20);




        gField.add(msgLabel);
        gField.add(scoreLabel);
        frame.getContentPane().add(gField);
        frame.setJMenuBar(menu);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Object[] possibilities = {"Player vs Player", "Player vs AI"};
        String s = (String)JOptionPane.showInputDialog(frame,
                "Choose game type...",
                "Let's Start!",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Player vs AI");
        if (s == "Player vs Player") initGGame(GGame.HUMAN);
        if (s == "Player vs AI")initGGame(GGame.AI);
        updateScore();
        startGameThread();
    }



    public static GGame getInstance() {
        return instance;
    }

   public void initGGame (String type){
        if (type == HUMAN){
            player2 = new GPlayerHuman("O");
        }else if (type == AI) {
            player2 = new PlayerAI("O");
        }

       player2.setName("Player_2");
       player1 = new GPlayerHuman("X");
       player1.setName("Player_1");
       curPlayer = new CurPlayer(player1,player2);
       game = new GameMechanismGUI(gField,curPlayer);
       gameThread = new Thread(this);
    }


    public static void showMsg(String msg){
        msgLabel.setText(msg);
    }

   public  void startGameThread() {
       if (!gameThread.isAlive() ){
           showMsg("START");
           gameThread.start();
       }
       updateScore();
       gField.ResetGField();
   }
    public void updateScore() {
        scoreLabel.setText(player1.getName() + " " + player1.getSymbol() + " " + player1.getWinCount() + " : " + player2.getWinCount() + " "+  player2.getSymbol() + " "  + player2.getName());
    }

    @Override
    public void turnHuman(GCell gCell) {
        if (!(curPlayer.getCurPlayer() instanceof GPlayerHuman) || game.endGame()) {
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


