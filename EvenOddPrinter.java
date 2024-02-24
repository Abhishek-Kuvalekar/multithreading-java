
class EvenPrinter extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(
                    String.format("Thread Id: %d, Current Number: %d", currentThread().getId(), i)
            );
        }
    }
}

class OddPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println(
                    String.format("Thread Id: %d, Current Number: %d", Thread.currentThread().getId(), i)
            );
        }
    }
}

public class EvenOddPrinter {
    public static void main(String[] args) {
        EvenPrinter evenPrinter = new EvenPrinter();
        evenPrinter.start();

        Thread oddPrinter = new Thread(new OddPrinter());
        oddPrinter.start();
    }
}
