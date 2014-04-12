package Others;


public class StackOut {

    public static void rec(){
        rec();
    }

    public static void main(String[] args) {
            rec();
            int i=+1;
        }

    }

