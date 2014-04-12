package seabattle_gui_logic_base;

public class SeaBattle {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Gui();

//        Runnable myRunnable = new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println("THIS IS THREAD" + Thread.currentThread().getName());
//                }
//
//            }
//        };
//
//        Thread thread = new Thread(myRunnable);
//        thread.start();
//
//        Thread thread2 = new Thread(myRunnable);
//        thread2.start();
    }

}
