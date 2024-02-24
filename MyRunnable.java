public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(
                String.format("Runnable with id: %d is running", Thread.currentThread().getId())
        );
    }

    public static void main(String[] args) {
        int numberOfThreads = 7;
        for (int i = 0; i < numberOfThreads; ++i) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }
}
