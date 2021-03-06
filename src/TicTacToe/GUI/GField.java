package TicTacToe.GUI;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import TicTacToe.model.*;


public class GField extends JComponent {
    private final static int FIELD_SIZE = 3;
    private final static int SIZE = 612;
    private URL imgFileName = getClass().getResource("/res/field.png");
    private Image img = Toolkit.getDefaultToolkit().getImage(imgFileName);
    private Field field;
    private GCell[][] gCells = new GCell[FIELD_SIZE][FIELD_SIZE];


    public GField(Field field, GPlayerHumanInterface controller) {
        this.field = field;
       for (int i = 0; i < FIELD_SIZE; i++) {
           for (int j = 0; j < FIELD_SIZE; j++) {
               Cell cell = field.getCell(i,j);
               gCells[i][j] = new GCell(i,j,cell,controller);
               this.add(gCells[i][j]);
           }
       }
        setSize(this.WIDTH, this.HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
           URL url;
           Graphics2D g2d = (Graphics2D) g;
           Image image;
           url = getClass().getResource("/res/field.png");
           image = Toolkit.getDefaultToolkit().getImage(url);
           g2d.drawImage(image,5,5,this);
           g2d.finalize();
           super.paint(g);
        }


    public Field getField () {
        return this.field;
    }


    public int Size(){return this.SIZE; }

    public void ResetGField (){
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                Cell cell = field.getCell(i,j);
                cell.setPlayer(null);
            }
        }
        repaint();
    }



}
