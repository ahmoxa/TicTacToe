package ru.home_work.february_2014.kozlov_leonid.nac.gui;

import ru.home_work.february_2014.kozlov_leonid.nac.logic.Cell;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GraphicCell extends JComponent implements MouseListener {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    private static Image[] images;

    private boolean selected = false;
    private boolean clicked = false;
    private boolean blocked = false;

    private Cell cell;

    public GraphicCell(int x, int y) {

        if (images == null) {
            URL imageName;
            images = new Image[4];

            imageName = getClass().getResource("/res/img/select.png");
            images[0] = Toolkit.getDefaultToolkit().getImage(imageName);

            imageName = getClass().getResource("/res/img/cross.png");
            images[1] = Toolkit.getDefaultToolkit().getImage(imageName);

            imageName = getClass().getResource("/res/img/zero.png");
            images[2] = Toolkit.getDefaultToolkit().getImage(imageName);

            imageName = getClass().getResource("/res/img/win.png");
            images[3] = Toolkit.getDefaultToolkit().getImage(imageName);
        }

        setSize(WIDTH, HEIGHT);
        setLocation(x, y);
        addMouseListener(this);
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        this.blocked = false;
        repaint();
    }

    public void setBlocked() {
        blocked = true;
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;

                g2d.drawImage(images[0], 0, 0, this);


        g2d.finalize();
    }

    public boolean isClicked() {
        boolean res = clicked;
        clicked = false;
        return res;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (blocked) return;
        selected = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (blocked) return;
        selected = false;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (blocked) return;
        selected = false;
        clicked = true;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

}
