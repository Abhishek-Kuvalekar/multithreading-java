class Counter {
    private int count = 0;

    public void increment() {
        try {
            ++count;
            Thread.sleep(100);
            System.out.println(String.format("Incremented Count: %d", count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void decrement() {
        try {
            --count;
            Thread.sleep(100);
            System.out.println(String.format("Decremented Count: %d", count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        try {
            ++count;
            Thread.sleep(100);
            System.out.println(String.format("Incremented Count: %d", count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void decrement() {
        try {
            --count;
            Thread.sleep(100);
            System.out.println(String.format("Decremented Count: %d", count));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        int limit = 10;

        Counter counter = new Counter();
        //SynchronizedCounter counter = new SynchronizedCounter();

        Thread incrementer = new Thread(
                new Runnable() {
                    @Override
                    public void run()  {
                        for (int i = 0; i < limit; ++i) counter.increment();
                    }
                }
        );

        Thread decrementer = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < limit; ++i) counter.decrement();
                    }
                }
        );

        incrementer.start();
        decrementer.start();

        try {
            incrementer.join();
            decrementer.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
