package Cross_Zero; /**
 * Created by Anton on 02.02.14.
 */
import java.util.*;
public class Game {
    //Задаем игровое поле
    char[][] area = {{'*','*','*'}, {'*','*','*'}, {'*','*','*'}};

    //Флаг первого игрока
    boolean isPlayer1 = true;

    //Отрисовка поля
    public void DrawArea () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println("");
        }
    }
    //Выполнения хода
    public void Step () {
        System.out.print("Enter your step (x and y)");
        int x,y;
        Scanner s = new Scanner(System.in);
        x = s.nextInt();
        y = s.nextInt();
        if (x > 3 || y > 3 || x < 0 || y < 0 ) {
            System.out.println("Incorrect input");
            this.Step();
        }
        System.out.print("Your step is \n");
        System.out.print("x:" + x + " y:" + y + "\n");
        if (this.isPlayer1) {
            area[x][y] = 'X';
        } else area[x][y] = 'O';
    }
    //Запуск игры
    public  void Start () {
        do {
            try {
                this.Step();
            } catch (InputMismatchException e) {
                System.out.print("Incorrect input\n");
                System.out.print(e + "\n");
                this.Step();
            }
            this.DrawArea();
            this.isPlayer1 = !this.isPlayer1;
        } while (!this.haveWinner(this.area));

    }
    //Проверка победителя
    public boolean haveWinner (char[][] mass) {
        //Проверяем строки на совпадения
        if (mass[0][0] != '*'&& mass[0][0]==mass[0][1] && mass[0][0] == mass[0][2]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }
        if (mass[1][0] != '*' && mass[1][0]==mass[1][1] && mass[1][0] == mass[1][2]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }
        if (mass[2][0] != '*' && mass[2][0]==mass[2][1] && mass[2][0] == mass[2][2]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }

        // Проверяем столбцы на совпадения
        if (mass[0][0]!='*' && mass[0][0]==mass[1][0] && mass[0][0] == mass[2][0]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }
        if (mass[0][1]=='X' &&  mass[0][1]==mass[1][1] && mass[0][1] == mass[2][1]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }
        if (mass[0][2]!='*' &&  mass[0][2]==mass[1][2] && mass[0][2] == mass[2][2]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }

        //Проверяем диагонали
        if (mass[0][0] != '*' && mass[0][0]==mass[1][1] && mass[0][0] == mass[2][2]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }
        if (mass[2][0] != '*' && mass[2][0]==mass[1][1] && mass[2][0] == mass[0][2]) {
            if (this.isPlayer1) {
                System.out.println("Player 2 is a WINNER!!!");
            } else System.out.println("Player 1 is a WINNER!!!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.Start();
    }

}
