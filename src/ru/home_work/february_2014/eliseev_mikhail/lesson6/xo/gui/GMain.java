package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.gui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Timer;
import java.util.TimerTask;

import ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model.*;

public class GMain implements PlayerHumanGUIInterface {

	private Field field;
	private Score score;
	
	private Player[] Players1Set = new Player[] {new Player('X', "Dummy"), new PlayerAi('X', "CPUAi"), new PlayerHumanGUI('X', "Human")};
	private Player[] Players2Set = new Player[] {new Player('O', "Dummy"), new PlayerAi('O', "CPUAi"), new PlayerHumanGUI('O', "Human")};
	private int players1SetIndex = 0;
	private int players2SetIndex = 1;
	
	private boolean flagCountdown;
	private int gameId;
	
	private GField gField;
	private JLabel labelScore;
	private JLabel labelMsg;
    
    public GMain() {
    
    	// окно
    	
	    JFrame frame = new JFrame("XO");
	    
	    frame.setLayout(null);
	    frame.setSize(GField.SIZE, GField.SIZE + 40);
	    frame.setLocationRelativeTo(null); // центрирует окно на экране
	    frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// пара игроков, игровое поле, счет
    	
    	Player player1 = Players1Set[players1SetIndex];
    	Player player2 = Players2Set[players2SetIndex];
 
    	field = new Field(player1, player2);
    	score = new Score(player1.getSymbol(), player2.getSymbol());
    	
        gField = new GField(field, this);
        frame.add(gField);
    	
    	// меню
    	
		JMenuBar menuBar = new JMenuBar();
		
        JMenuItem menuItemFieldReset = new JMenuItem("Reset Field");
        menuItemFieldReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fieldReset();
            }
        });
        
        JMenuItem menuItemScoreReset = new JMenuItem("Reset Score");
        menuItemScoreReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	scoreReset();
            }
        });
        
        menuBar.add(menuItemFieldReset);
        menuBar.add(menuItemScoreReset);
        frame.setJMenuBar(menuBar);
        
        // верхняя лейба со счетом и переключателем типов игроков (Dummy, Ai, Human)
        
        labelScore = new JLabel();
        labelScore.setHorizontalAlignment(JLabel.CENTER);
        labelScore.setVerticalAlignment(JLabel.CENTER);
        labelScore.setSize(GField.SIZE, 30);
        labelScore.setLocation(0, 10);
        labelScore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        labelScore.addMouseListener(new MouseAdapter() {
        	@Override  
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getX() < gField.SIZE / 2) { // не будем пока заморачиваться
					field.changePlayer(nextPlayerFrom1Set(), 1);
		    	} else {
					field.changePlayer(nextPlayerFrom2Set(), 2);
		    	}
		    	displayScore();
		    	++gameId;
				afterTurn();
		    }
		});
        
        gField.add(labelScore);
        
        // нижняя лейба для сообщений
        
        labelMsg = new JLabel();
        labelMsg.setHorizontalAlignment(JLabel.CENTER);
        labelMsg.setVerticalAlignment(JLabel.CENTER);
        labelMsg.setSize(GField.SIZE, 30);
        labelMsg.setLocation(0, 265);
        gField.add(labelMsg);
        
        //
    	
    	frame.setVisible(true);
    	
    	// go
    	
    	displayScore();
    	turn();
    }
    
    @Override
    public void turnHuman(FieldPos pos) {
    	if (!(field.getCurPlayer() instanceof PlayerHumanGUI)) {
		    return;
	    }
	    if (field.addMove(pos, field.getCurPlayer())) {
		   afterTurn();
	    }
    }
    
    private void turn() {
    	if (field.isGameOver()) {
	    	return;
    	}
    	Player player = field.getCurPlayer();
		showMsg(player.getSymbol() + "'s turn");
		
	    if (!(player instanceof PlayerHumanGUI)) {
	    	int curGameId = gameId;
	    	delay(800);
	    	if (curGameId != gameId) {
		    	return;
	    	}
			while (!field.addMove(player.nextMove(field.getField()), player));
			afterTurn();
	    }
    }
    
    private void afterTurn() {
		gField.repaint();
		// System.out.println(field);
		if (field.isGameOver()) {
			if (field.checkWin()) {
				score.increment(field.getCurPlayer().getSymbol());
				displayScore();
				showMsg(field.getCurPlayer().getSymbol() + " wins!");
			} else if (!field.hasEmptyCells()) {
				showMsg("Tie!");
			}
			// через таймер, чтобы основной поток мог перерисовать компоненты без задержки (чет не разобрался как явно вызывать repaint в основном потоке)
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					countdown(0);
				}
			}, 1);
		} else {
			// http://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					turn();
				}
			}, 1);
		}
    }
    
    private void fieldReset() {
    	++gameId;
    	flagCountdown = false;
	    field.reset();
	    afterTurn();
    }
    
    private void scoreReset() {
	    score.resetScore();
	    displayScore();
    }
    
    private void countdown(int i) {
    	if (i == 0) {
    		flagCountdown = true;
	    	delay(2000);
    	}
	    if (i < 3) {
		    countdown(i + 1);
	    }
	    if (flagCountdown) {
		    showMsg(Integer.toString(i));
		    delay(1000);
			if (i == 0) {
				fieldReset();
			}
		}
    }
    
    private void displayScore() {
	    labelScore.setText("<html><b><font color='#e6304e'>(" + Players1Set[players1SetIndex].getName() + ") " + score.getScore(Players1Set[players1SetIndex].getSymbol()) + "</font> <font color='white'>:</font> <font color='#00aeef'>" + score.getScore(Players2Set[players2SetIndex].getSymbol()) + " (" + Players2Set[players2SetIndex].getName() + ")</font></b></html>");
    }
    
    private void showMsg(String msg) {
    	labelMsg.setText("<html><font color='white'><b>" + msg + "</b></font></html>");
    }
    
    private void delay(int msec) {
    	// http://stackoverflow.com/questions/3342651/how-can-i-delay-a-java-program-for-a-few-seconds
		try {
		    Thread.sleep(msec);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
    }
    
    private Player nextPlayerFrom1Set() {
	    if (++players1SetIndex == Players1Set.length) {
			players1SetIndex = 0;
	    }
	    return Players1Set[players1SetIndex];
    }
    
    private Player nextPlayerFrom2Set() {
	    if (++players2SetIndex == Players2Set.length) {
			players2SetIndex = 0;
	    }
	    return Players2Set[players2SetIndex];
    }
}