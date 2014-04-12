package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.gui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model.*;

class GCell extends JComponent implements MouseListener {

	private static final int SIZE = 55;
	
	PlayerHumanGUIInterface controller;
	
	private int cellId;
    private Cell cell;

    public GCell(PlayerHumanGUIInterface controller, int cid, Cell c, int y, int x) {
    	this.controller = controller;
    	cellId = cid;
    	cell = c;
    	setSize(SIZE, SIZE);
    	setLocation(50 + (SIZE + 20) * x, 65 + (SIZE + 10) * y);
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        char playerSymbol = cell.getPlayer() == null ? '_' : cell.getPlayer().getSymbol();		
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui_res/cell" + playerSymbol + ".png"));
        g2.drawImage(img, 0, 0, this);
		// g2.finalize(); // ?
		super.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (cell.getPlayer() == null) {
        	controller.turnHuman(FieldPos.num2pos(cellId));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	if (cell.getPlayer() == null) {
    		// http://stackoverflow.com/questions/7359189/how-to-change-the-mouse-cursor-in-java
	    	setCursor(new Cursor(Cursor.HAND_CURSOR));
    	}
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
	    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
}