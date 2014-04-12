package ru.home_work.february_2014.kozlov_leonid.nac.gui;

import javax.swing.*;

public class Gui {

    public static Gui out = new Gui();

    private JFrame graphicFrame;
    public GraphicField graphicField;
    public Menu menuBar;

    public Gui () {
        // Создаём окно
        graphicFrame = new JFrame("NAC");
        graphicFrame.setLayout(null);
        graphicFrame.setLocationRelativeTo(null);

        // Создаём меню
        menuBar = new Menu();
        graphicFrame.setJMenuBar(menuBar);

        // Создаём игровое поле
        graphicField = new GraphicField();
        graphicFrame.add(graphicField);

        // Определяем параметры окна и выводим его
        graphicFrame.setSize(GraphicField.WIDTH + 8, GraphicField.HEIGHT + 48);
        graphicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphicFrame.setResizable(false);
        graphicFrame.setVisible(true);
    }

    public void waitRestart() {

        // Блокируем игровую активность
        Gui.out.graphicField.blockCells();

        // Ожидаем рестарт игры
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            if (Gui.out.menuBar.isRestart()) break;
        }
        return;
    }

    public boolean isRestart() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        return Gui.out.menuBar.isRestart();
    }

}


