public class MyThread extends Thread {
    public void run() {
        System.out.println(
                String.format("Thread with id: %d is running", currentThread().getId())
        );
    }

    public static void main(String[] args) {
        int numberOfThreads = 7;

        for (int i = 0; i < numberOfThreads; ++i) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }
}
