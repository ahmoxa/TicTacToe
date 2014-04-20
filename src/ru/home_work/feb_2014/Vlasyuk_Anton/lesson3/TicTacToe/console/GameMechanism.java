package ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.console;


import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.GUI.GField;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Field;
import ru.home_work.feb_2014.Vlasyuk_Anton.lesson3.TicTacToe.model.Player;

public class GameMechanism {
    private Field field;
    private Player p1;
    private Player p2;
    private CurPlayer curPlayer;
    GField gField ;



    public GameMechanism(Field field, Player p1, Player p2){
        this.field = field;
        this.p1 = p1;
        this.p2 = p2;
    }

    public GameMechanism(GField gField, Player p1, Player p2){
        this.field = gField.field;
        this.gField = gField;
        this.p1 = p1;
        this.p2 = p2;
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

//Вывод на консоль результата игры
    public void PrintResult(){
        if (this.haveWin() != null) {
            System.out.println(this.haveWin().getSymbol() + " is a WINNER");
        } else {
            System.out.println("Tie!");
        }
    }

    public boolean endGame() {
        if (haveWin() != null || fieldFilled(field)) {
            return true;
        }
        else return false;
    }



//Запуск игрового процесса
    public  void Start () {
        curPlayer =  new CurPlayer(p1,p2);
        curPlayer.setCurPlayer(p1);
        do {
            curPlayer.getCurPlayer().Move(field);
            for (int i = 0; i < field.getFIELD_SIZE(); i++) {
                for (int j = 0; j < field.getFIELD_SIZE(); j++) {
                    this.gField.gCells[i][j].repaint();

                }
            }
            this.field.Display();
            curPlayer.getSwitchedCurPlayer();

        } while (!endGame());

        PrintResult();
    }
}
