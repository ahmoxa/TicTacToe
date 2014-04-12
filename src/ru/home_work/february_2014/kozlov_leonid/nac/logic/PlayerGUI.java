package ru.home_work.february_2014.kozlov_leonid.nac.logic;

import ru.home_work.february_2014.kozlov_leonid.nac.gui.Gui;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Cell;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Judge;
import ru.home_work.february_2014.kozlov_leonid.nac.logic.Player;

public class PlayerGUI extends Player {

    @Override
    public Cell selectNextCell(Judge judge) {
        Cell nextCell;
        int cellNumber;
        while (true) {
            if (Gui.out.isRestart()) return null;

            cellNumber = Gui.out.graphicField.getClickedCell();

            nextCell = judge.getField().getCell(cellNumber);
            if (nextCell == null) continue;
            if (nextCell.getPlayer() != null) continue;

            return nextCell;
        }
    }


}
