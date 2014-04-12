package Others;

import javax.swing.*;
import java.awt.event.*;

public class GUI_test implements ActionListener {

    JButton button;
    JButton buttontwo;


    public static void main(String[] args) {
        GUI_test gui = new GUI_test();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click me!");
        buttontwo = new JButton("Try me!");
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(buttontwo);

        button.addActionListener(this);
        buttontwo.addMouseListener(new buttonMouse());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class buttonMouse implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
//            buttontwo.setText("Im clicked!");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
//            buttontwo.setText("Im entered");
        }
        @Override
        public void mouseExited(MouseEvent e) {
//            buttontwo.setText("Im exited");
        }
        @Override
        public void mousePressed(MouseEvent e) {
            buttontwo.setText("Im pressed");
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            buttontwo.setText("Im realesed");
        }
    }

    public void actionPerformed(ActionEvent event){
        button.setText("CLICKED!");
    }
}
