class Printer {
    private int limit;
    public Printer(int limit) {
        this.limit = limit;
    }
    public synchronized void printOdd() {
        for (int i = 1; i <= limit; i += 2) {
            try {
                System.out.println(String.format("Thread %s: %d", Thread.currentThread().getName(), i));
                notify();
                wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        notify();
    }

    public synchronized void printEven() {
        for (int i = 0; i <= limit; i += 2) {
            try {
                System.out.println(String.format("Thread %s: %d", Thread.currentThread().getName(), i));
                notify();
                wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        notify();
    }
}
public class EvenOddSequentialPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer(100);

        Thread evenPrinter = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        printer.printEven();
                    }
                }
        );

        Thread oddPrinter = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        printer.printOdd();
                    }
                }
        );

        evenPrinter.start();
        oddPrinter.start();
    }
}
