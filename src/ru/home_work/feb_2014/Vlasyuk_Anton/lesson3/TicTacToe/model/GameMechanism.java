package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model;

import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GField;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console.CurPlayer;

/**
 * Created by anton on 30.04.14.
 */
public class GameMechanism {
    protected Field field;
    protected CurPlayer curPlayer;
    private boolean endGame;




    public GameMechanism(Field field,CurPlayer curPlayer){
        this.field = field;
        this.curPlayer = curPlayer;
        endGame = false;

    }
    //Проверка на заполненость поля. Заполнено - true, или - false
    public boolean fieldFilled(Field field){
        for (int i = 0; i < field.getFIELD_SIZE(); i++){
            for (int j = 0; j < field.getFIELD_SIZE(); j++) {
                if (field.getCell(i,j).getPlayer() == null)
                    return false;
            }
        }
        return true;
    }

    //Проверка на победителя по строкам
    public Player checkRowsWin() {
        for (int i = 0; i < field.getFIELD_SIZE(); i++){
            if (field.getCell(i,0).getPlayer() != null &&
                    field.getCell(i,0).getPlayer() == field.getCell(i,1).getPlayer() &&
                    field.getCell(i,0).getPlayer() == field.getCell(i,2).getPlayer()) {
                return field.getCell(0,i).getPlayer();
            }
        }
        return null;
    }

    //Проверка на победителя по столбцам
    public Player checkColumnsWin() {
        for (int i = 0; i < field.getFIELD_SIZE(); i++){
            if (field.getCell(0,i).getPlayer() != null &&
                    field.getCell(0,i).getPlayer() == field.getCell(1,i).getPlayer() &&
                    field.getCell(0,i).getPlayer() == field.getCell(2,i).getPlayer()) {
                return field.getCell(0,i).getPlayer();
            }
        }
        return null;
    }

    //Проверка на победителя по диагоналям
    public Player checkDiagsWin(){
        if (field.getCell(0,0).getPlayer()!= null &&
                field.getCell(0,0).getPlayer() == field.getCell(1,1).getPlayer() &&
                field.getCell(0,0).getPlayer() == field.getCell(2,2).getPlayer()) {
            return  field.getCell(0,0).getPlayer();
        }
        if (field.getCell(0,2).getPlayer()!= null &&
                field.getCell(0,2).getPlayer() == field.getCell(1,1).getPlayer() &&
                field.getCell(0,2).getPlayer() == field.getCell(2,0).getPlayer()) {
            return  field.getCell(0,0).getPlayer();
        }
        return null;
    }

    //Проверка на победителя. Возвращает объект класса Player или null если нет победителя
    public Player haveWin(){
        if  (checkColumnsWin() != null) {
            return checkColumnsWin();
        } else if (checkDiagsWin() != null) {
            return checkDiagsWin();
        } else if (checkRowsWin() != null) {
            return  checkRowsWin();
        } else return null;

    }

    public boolean endGame() {
        if (haveWin() != null || fieldFilled(field)) {
            endGame = true;
            return endGame;
        }
        else {
            endGame = false;
            return endGame;
        }
    }


}
