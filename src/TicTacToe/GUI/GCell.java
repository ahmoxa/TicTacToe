package TicTacToe.GUI;


import TicTacToe.model.Cell;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GCell extends JComponent implements MouseListener {

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    public static final int SIZE = 140;
    GPlayerHumanInterface controller;
    boolean mouseEnter = false;
    private Cell cell;


    public GCell(int x, int y, Cell cell, GPlayerHumanInterface controller) {
        this.cell = cell;
        this.controller = controller;
        setSize(SIZE,SIZE);
        addMouseListener(this);
        setLocation((y*180+50),(x*180)+80);
    }

    public void paint(Graphics g) {
        URL url;
        Graphics2D g2d = (Graphics2D) g;
        Image image;
        if (cell.getPlayer() == null) {
            if (mouseEnter) {
                url = getClass().getResource("/res/select.png");
                image = Toolkit.getDefaultToolkit().getImage(url);
                g2d.drawImage(image,5,5,this);
                g2d.finalize();
                super.paint(g);
            } else {
                url = getClass().getResource("/res/empty.png");
                image = Toolkit.getDefaultToolkit().getImage(url);
                g2d.drawImage(image,5,5,this);
                g2d.finalize();
                super.paint(g);
            }
        }else if (cell.getPlayer().getSymbol() == PLAYER_X ) {
            url = getClass().getResource("/res/cross.png");
            image = Toolkit.getDefaultToolkit().getImage(url);
            g2d.drawImage(image,5,5,this);
            g2d.finalize();
            super.paint(g);
        } else if (cell.getPlayer().getSymbol() == PLAYER_O ) {
            url = getClass().getResource("/res/zero.png");
            image = Toolkit.getDefaultToolkit().getImage(url);
            g2d.drawImage(image,5,5,this);
            g2d.finalize();
            super.paint(g);
        }
    }

    public Cell getCell () {
        return cell;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       if (cell.getPlayer() == null) {
           controller.turnHuman(this);
           repaint();
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEnter = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseEnter = false;
        repaint();
    }
}
