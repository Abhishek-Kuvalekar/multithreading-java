import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Worker implements Runnable {
    private int field;

    public Worker(int i) {
        field = i;
    }

    @Override
    public void run() {
        try {
            /*System.out.println(
                    String.format(
                            "Thread %s is started with field: %d",
                            Thread.currentThread().getName(),
                            field
                    )
            );*/

            Thread.sleep(50);

            /*System.out.println(
                    String.format(
                            "Thread %s is terminating",
                            Thread.currentThread().getName()
                    )
            );*/
        } catch (Exception ex) {
            System.out.println(
                    String.format(
                            "Something went wrong with thread %s",
                            Thread.currentThread().getName()
                    )
            );
        }
    }
}
public class ThreadPoolDemo {
    private static ExecutorService executorService;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        startWithoutThreadPool();
        long endTime = System.currentTimeMillis();
        System.out.println(
                String.format(
                        "Time taken to start threads without a thread pool: %d milliseconds",
                        (endTime  - startTime)
                )
        );

        executorService = Executors.newCachedThreadPool();
        System.out.println("Thread pool is created");
        startTime = System.currentTimeMillis();
        startWithThreadPool();
        endTime = System.currentTimeMillis();
        System.out.println(
                String.format(
                        "Time taken to start threads with a thread pool: %d milliseconds",
                        (endTime  - startTime)
                )
        );

        executorService.shutdown();
        while (!executorService.isTerminated());
        System.out.println("Thread pool is destroyed");
    }

    private static void startWithoutThreadPool() {
        for (int i = 0; i < 1000; ++i) {
            Thread thread = new Thread(new Worker(i));
            thread.start();
        }
    }

    private static void startWithThreadPool() {
        for (int i = 0; i < 1000; ++i) {
            executorService.execute(new Worker(i));
        }
    }
}
