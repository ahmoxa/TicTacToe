package ru.home_work.february_2014.kozlov_leonid.nac.logic;

import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;

public class Line {

    private static final int LEVEL1_WEIGHT = 30000;
    private static final int LEVEL2_WEIGHT = 20000;
    private static final int LEVEL3_WEIGHT = 10000;
    private static final int LEVEL4_WEIGHT = 5000;
    private static final int LEVEL5_WEIGHT = 0;
    private static final int MAX_RANDOM = 1000;
    private static Random random = new Random();


    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private Player cellPlayer;

    public void add(Cell cell) {
        if (cell != null) cells.add(cell);
    }

    public boolean isWinLine(Player player) {
        int count = 0;
        for (int i = 0; i < cells.size(); i++) {
            cellPlayer = cells.get(i).getPlayer();
            if (cellPlayer == null) break;
            if (cellPlayer.equals(player)) count++;
        }
        if (count == cells.size()) {
            for (int i = 0; i < cells.size(); i++) {
                cells.get(i).setWinCell();
            }
            return true;
        } else {
            return false;
        }
    }

    public void goWeighting(Player player) {
        int lineWeight;
        int count = 0;
        for (int i = 0; i < cells.size(); i++) {
            cellPlayer = cells.get(i).getPlayer();
            if (cellPlayer != null) {
                if (cellPlayer.equals(player)) count++ ;
                if (!cellPlayer.equals(player)) count--;
            }
        }
        int delta = Math.abs(random.nextInt(MAX_RANDOM)) % MAX_RANDOM;
        switch (count) {
            case 2:
                lineWeight = LEVEL1_WEIGHT + delta;
                break;
            case -2:
                lineWeight = LEVEL2_WEIGHT + delta;
                break;
            case 1:
                lineWeight = LEVEL3_WEIGHT + delta;
                break;
            case 0:
                lineWeight = LEVEL4_WEIGHT + delta;
                break;
            case -1:
                lineWeight = LEVEL4_WEIGHT + delta;
                break;
            default:
                lineWeight = LEVEL5_WEIGHT;
        }
        for (int i = 0; i < cells.size(); i++) {
            cells.get(i).setWeight(lineWeight);
        }
    }
}
