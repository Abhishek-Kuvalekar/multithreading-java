class MyGroupedRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(
            String.format(
                    "Thread %s belongs to thread group %s",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getThreadGroup().getName()
            )
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println(
                    String.format("Thread %s is interrupted", Thread.currentThread().getName())
            );
        }
    }
}
public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup parentThreadGroup = new ThreadGroup("ParentThreadGroup");
        ThreadGroup childThreadGroup = new ThreadGroup(parentThreadGroup, "ChildThreadGroup");

        Thread threadInParent = new Thread(parentThreadGroup, new MyGroupedRunnable(), "ThreadInParent");
        Thread threadInChild = new Thread(childThreadGroup, new MyGroupedRunnable(), "ThreadInChild");
        Thread threadWithoutThreadGroup = new Thread(new MyGroupedRunnable(), "ThreadInDefaultThreadGroup");

        threadInParent.start();
        threadInChild.start();
        threadWithoutThreadGroup.start();

        parentThreadGroup.interrupt();
    }
}
