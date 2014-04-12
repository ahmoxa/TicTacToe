package ru.home_work.february_2014.kozlov_leonid.nac.gui;

import ru.home_work.february_2014.kozlov_leonid.nac.logic.Field;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GraphicField extends JComponent {

    public static final int HEIGHT = 512;
    public static final int WIDTH = 512;

    private URL imgFileName = getClass().getResource("/res/img/field.png");
    private Image img = Toolkit.getDefaultToolkit().getImage(imgFileName);

    private int[] cellXPosition = {32, 210, 370,  40, 205, 370,  45, 200, 365};
    private int[] cellYPosition = {80,  70,  65, 220, 205, 200, 355, 340, 335};
    private GraphicCell graphicCells[] = new GraphicCell[9];

    public GraphicField() {
        for (int i = 0; i < 9; i++) {
            graphicCells[i] = new GraphicCell(cellXPosition[i], cellYPosition[i]);
            this.add(graphicCells[i]);
        }
        setSize(this.WIDTH, this.HEIGHT);
    }

    public void setCells(Field field) {
        for (int i = 0; i < 9; i++) {
            graphicCells[i].setCell(field.getCell(i));
        }
    }

    public void blockCells() {
        for (int i = 0; i < 9; i++) {
            graphicCells[i].setBlocked();
        }
    }


    public int getClickedCell() {
        for (int i = 0; i < 9; i++) {
            if (graphicCells[i].isClicked()) {
                return i;
            }
        }
        return 9;
    }

    public void doRepaintCells() {
        for (int i = 0; i < 9; i++) {
            graphicCells[i].repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.img, 0, 0, this);
        g2d.finalize();
        super.paint(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        GraphicField graphicField = new GraphicField();
        frame.getContentPane().add(graphicField);
    }

}
