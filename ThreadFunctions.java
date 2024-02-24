import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreadFunctions implements Runnable {
    @Override
    public void run() {
        System.out.println(
                String.format("%s is started", Thread.currentThread().getName())
        );
        try {
            System.out.println(
                    String.format("%s is going to sleep", Thread.currentThread().getName())
            );
            Thread.sleep(3000);
            System.out.println(
                    String.format("%s is resumed", Thread.currentThread().getName())
            );
        } catch (Exception ex) {
            System.out.println(
                    String.format("Oops! Something went wrong in %s", Thread.currentThread().getName())
            );
        }

        System.out.println(
                String.format("%s is ended", Thread.currentThread().getName())
        );
    }

    public static void main(String[] args) {
        try {
            Thread threadOne = new Thread(new ThreadFunctions(), "ThreadOne");
            Thread threadTwo = new Thread(new ThreadFunctions(), "ThreadTwo");
            threadOne.start();
            //threadOne.join();
            threadTwo.start();
            //threadOne.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
