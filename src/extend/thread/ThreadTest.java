package extend.thread;

public class ThreadTest{

    public static void main(String[] args) throws InterruptedException {
        Runnable fatherThread = new FatherThread();
        Thread thread = new Thread(fatherThread);
        thread.start();
        thread.join();
    }
}

class FatherThread implements Runnable{
    @Override
    public void run() {
        System.out.println("father is running");
        try {
            Thread.sleep(1000);
            Runnable sonThread = new SonThread();
            Thread thread = new Thread(sonThread);
            Thread thread2 = new Thread(sonThread);
            thread.start();
            thread2.start();

            System.out.println("father thread over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SonThread implements Runnable{

    @Override
    public void run() {
        System.out.println("son is running");
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("son thread over");
    }
}
