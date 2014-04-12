package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe;



/**
 * Created by Anton on 08.03.14.
 */
public class PlayerAI extends Player {

    public PlayerAI(String symbol) {
        super(symbol);
    }

// Проверяем строки на 2 совпадения и возвращаем третью ячейку, если она свободна
    public Cell checkRowsTwoSame(Field field) {
        for (int i = 0; i < field.getFIELD_SIZE(); i++){
            if (field.getCell(i,0).getPlayer() != null &&
                field.getCell(i,0).getPlayer() == field.getCell(i,1).getPlayer() &&
                field.getCell(i,2).getPlayer() == null)
                    return field.getCell(i,2);
            if (field.getCell(i,0).getPlayer() != null &&
                field.getCell(i,0).getPlayer() == field.getCell(i,2).getPlayer() &&
                field.getCell(i,1).getPlayer() == null)
                    return field.getCell(i,1);
            if (field.getCell(i,1).getPlayer() != null &&
                field.getCell(i,1).getPlayer() == field.getCell(i,2).getPlayer() &&
                field.getCell(i,0).getPlayer() == null)
                    return field.getCell(i,0);
        }
        return null;
    }

//Проверяем столбцы на 2 совпадения и возвращаем третью ячейку, если она свободна
    public Cell checkColumnsTwoSame(Field field) {
        for (int i = 0; i < field.getFIELD_SIZE(); i++) {
            if (field.getCell(0,i).getPlayer() != null &&
                field.getCell(0,i).getPlayer() == field.getCell(1,i).getPlayer() &&
                field.getCell(2,i).getPlayer() == null)
                    return field.getCell(2,i);
            if (field.getCell(0,i).getPlayer() != null &&
                field.getCell(0,i).getPlayer() == field.getCell(2,i).getPlayer() &&
                field.getCell(1,i).getPlayer() == null)
                    return field.getCell(1,i);
            if (field.getCell(1,i).getPlayer() != null &&
                field.getCell(1,i).getPlayer() == field.getCell(2,i).getPlayer() &&
                field.getCell(0,i).getPlayer() == null)
                    return field.getCell(0,i);
        }
        return null;
    }

//Проверяем диагонали на 2 совпадения и возвращаем третью ячейку, если она свободна
    public Cell checkDiagsTwoSame(Field field) {
        if (field.getCell(0,0).getPlayer() != null &&
            field.getCell(0,0).getPlayer() == field.getCell(1,1).getPlayer() &&
            field.getCell(2,2).getPlayer() == null)
                return field.getCell(2, 2);
        if (field.getCell(0,0).getPlayer() != null &&
            field.getCell(0,0).getPlayer() == field.getCell(2,2).getPlayer() &&
            field.getCell(1,1).getPlayer() == null)
                return field.getCell(1, 1);
        if (field.getCell(2,2).getPlayer() != null &&
            field.getCell(2,2).getPlayer() == field.getCell(1,1).getPlayer() &&
            field.getCell(0,0).getPlayer() == null)
                return field.getCell(0, 0);

        if (field.getCell(2,0).getPlayer() != null &&
            field.getCell(2,0).getPlayer() == field.getCell(1,1).getPlayer() &&
            field.getCell(0,2).getPlayer() == null)
                return field.getCell(0,2);
        if (field.getCell(2,0).getPlayer() != null &&
            field.getCell(2,0).getPlayer() == field.getCell(0,2).getPlayer() &&
            field.getCell(1,1).getPlayer() == null)
                return field.getCell(1,1);
        if (field.getCell(1,1).getPlayer() != null &&
            field.getCell(1,1).getPlayer() == field.getCell(0,2).getPlayer() &&
            field.getCell(2,0).getPlayer() == null)
                return field.getCell(2,0);

        return null;
    }

//Проверяем все поле на 2 совпадения
    public Cell TwoSame (Field field) {
        if  (checkColumnsTwoSame(field) != null) {
            return checkColumnsTwoSame(field);
        } else if (checkDiagsTwoSame(field) != null) {
            return checkDiagsTwoSame(field);
        } else if (checkRowsTwoSame(field) != null) {
            return  checkRowsTwoSame(field);
        } else return null;
    }

//Проверяем центр и если он не занят возвращаем ячейку
    public Cell getCenter(Field field) {
        if (field.getCell(1,1).getPlayer() == null) {
            return field.getCell(1,1);
        }
        else {
            return null;
        }

    }

//Проверяем углы и если не заняты возвращаем ячейку угла
    public Cell getCorner(Field field) {
        int size =0;
        for (int i = 0; i < field.getFIELD_SIZE(); i+=2) {
            for (int j = 0; j < field.getFIELD_SIZE(); j+=2) {
                if (field.getCell(i,j).getPlayer() == null) {
                    size++;
                    return field.getCell(i,j);
                }
            }
        }

        return null;
    }

//Возвращаем  пустую ячейку
    public Cell getFreeCell(Field field) {
        for (int i = 0; i < field.getFIELD_SIZE(); i++ ) {
            for (int j = 0; j < field.getFIELD_SIZE(); j++) {
                if (field.getCell(i,j).getPlayer() == null)
                    return field.getCell(i,j);
            }
        }
        return null;
    }

    public Cell getCellmove(Field field) {
        Cell twoSame = TwoSame(field);
        Cell center = getCenter(field);
        Cell corner = getCorner(field);
        Cell free = getFreeCell(field);

        if (twoSame!= null) {
            return field.getCell(twoSame.getX(),twoSame.getY());
        }
        if (center != null) {
            return field.getCell(center.getX(),center.getY());
        }
        if (corner !=null) {
            return field.getCell(corner.getX(),corner.getY());
        }
        if (free != null) {
            return field.getCell(free.getX(),free.getY());
        }
        return null;
    }


    @Override
    public void Move(Field field) {
        System.out.println("Turn is  " + this.getSymbol() + ":");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {


        }

        Cell move = getCellmove(field);
        if (move != null) {
            field.getCell(move.getX(), move.getY()).setPlayer(this);
        }
        else {
            System.out.println("Oh shit. I dont know where to move!");
        }
    }


}
