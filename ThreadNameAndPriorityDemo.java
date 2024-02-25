class MyNamedRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(
                String.format(
                        "Thread with name: %s started running with priority: %d",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority()
                )
        );

        switch (Thread.currentThread().getPriority()) {
            case Thread.MIN_PRIORITY:
                System.out.println(
                        String.format(
                                "Thread with name: %s is running with MIN_PRIORITY",
                                Thread.currentThread().getName()
                        )
                );
                break;
            case Thread.NORM_PRIORITY:
                System.out.println(
                        String.format(
                                "Thread with name: %s is running with NORM_PRIORITY",
                                Thread.currentThread().getName()
                        )
                );
                break;
            case Thread.MAX_PRIORITY:
                System.out.println(
                        String.format(
                                "Thread with name: %s is running with MAX_PRIORITY",
                                Thread.currentThread().getName()
                        )
                );
                break;
        }
    }
}
public class ThreadNameAndPriorityDemo {
    public static void main(String[] args) {
        Thread unnamedThread1 = new Thread(new MyNamedRunnable());
        unnamedThread1.start();

        Thread unnamedThread2 = new Thread(new MyNamedRunnable());
        unnamedThread2.start();

        Thread threadWithMinPriority = new Thread(new MyNamedRunnable());
        threadWithMinPriority.setName("ThreadWithMinPriority");
        threadWithMinPriority.setPriority(Thread.MIN_PRIORITY);
        threadWithMinPriority.start();

        Thread threadWithMaxPriority = new Thread(new MyNamedRunnable());
        threadWithMaxPriority.setName("ThreadWithMaxPriority");
        threadWithMaxPriority.setPriority(Thread.MAX_PRIORITY);
        threadWithMaxPriority.start();

        Thread threadWithIntermediatePriority = new Thread(new MyNamedRunnable());
        threadWithIntermediatePriority.setName("ThreadWithIntermediatePriority");
        threadWithIntermediatePriority.setPriority(7);
        threadWithIntermediatePriority.start();

    }
}
