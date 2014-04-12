package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.Cell;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.Player;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.PlayerHuman;

import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.net.URI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GCell extends JComponent implements MouseListener {

//    private Player player;

    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";
    private boolean selected = false;
    private static int SIZE = 140;
    private Cell cell;

//
    public GCell(int x, int y, Cell cell, Player player) {
//        this.player = player;
        this.cell = cell;
        setSize(SIZE,SIZE);
        addMouseListener(this);
        setLocation((180*y),(180*x));
    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//
//    public Player getPlayer(){
//        return this.player;
//    }



    public void paint(Graphics g) {
        URL url;
        Graphics2D g2d = (Graphics2D) g;
        Image image;
        if (cell.getPlayer() == null) {
            url = getClass().getResource("/res//empty.png");
            image = Toolkit.getDefaultToolkit().getImage(url);
            g2d.drawImage(image,5,5,this);
        }else if (cell.getPlayer().getSymbol() == PLAYER_X && selected) {
            url = getClass().getResource("/res//cross.png");
            image = Toolkit.getDefaultToolkit().getImage(url);
            g2d.drawImage(image,5,5,this);
        } else if (cell.getPlayer().getSymbol() == PLAYER_O && selected) {
            url = getClass().getResource("/res//zero.png");
            image = Toolkit.getDefaultToolkit().getImage(url);
            g2d.drawImage(image,5,5,this);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        selected = true;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
