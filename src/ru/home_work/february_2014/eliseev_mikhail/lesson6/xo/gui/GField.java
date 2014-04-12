package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.gui;

import java.awt.*;
import javax.swing.*;

import ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.model.*;

class GField extends JComponent {

	public static final int SIZE = 300;
	
	private Field field;
	private GCell[][] gCells = new GCell[Field.SIZE][Field.SIZE];

    public GField(Field f, PlayerHumanGUIInterface controller) {
		field = f;

        setSize(SIZE, SIZE);
		// setLocation(0, 0); // задает смещение относительно контейнера
		
		Cell[][] cells = field.getField();
        for (int cellId = 0, y = 0; y < Field.SIZE; y++) {
            for (int x = 0; x < Field.SIZE; x++) {
            	Cell cell = cells[y][x];
            	gCells[y][x] = new GCell(controller, ++cellId, cell, y, x);
                this.add(gCells[y][x]);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui_res/fieldEmpty.png"));
        g2.drawImage(img, 0, 0, this);
		// g2.finalize(); // зачем это нужно?
		super.paint(g);
    }
}