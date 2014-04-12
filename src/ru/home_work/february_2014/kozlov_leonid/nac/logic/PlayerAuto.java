package ru.home_work.february_2014.kozlov_leonid.nac.logic;

import ru.home_work.february_2014.kozlov_leonid.nac.logic.Cell;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Field;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Judge;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Player;

public class PlayerAuto extends Player {

    @Override
    public Cell selectNextCell(Judge judge) {
        int maxWeight = 0;
        Cell nextCell = null;
        judge.goWeighting();
        for (int i = 0; i < Field.CELLS_COUNT; i++) {
            Cell cell = judge.getField().getCell(i);
            int cellWeight = cell.getWeight();
            if (cellWeight > maxWeight) {
                if (cell.getPlayer() == null) {
                    maxWeight = cellWeight;
                    nextCell = cell;
                }
            }
        }

        try {
          Thread.sleep(300); // Задержка 300мс для интерактивности
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return nextCell;
    }

}
