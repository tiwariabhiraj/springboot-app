package EcecutorServiceEx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        System.out.println(
                "Task " + taskId + " executed by " + Thread.currentThread().getName()
        );

        try {
            Thread.sleep(2000); // simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Task " + taskId + " completed");
    }
}

public class ThreadPoolExecutorsEx {

    public  static  void start(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                          // core pool size
                4,                          // max pool size
                10,                         // keep alive time
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), // queue size
                new ThreadPoolExecutor.CallerRunsPolicy() // rejection policy
        );

        for (int i = 1; i <= 10; i++) {

            Task task = new Task(i);

            System.out.println("Submitting task " + i);

            executor.execute(task);

            System.out.println(
                    "Pool Size: " + executor.getPoolSize()
                            + " | Active Threads: " + executor.getActiveCount()
                            + " | Queue Size: " + executor.getQueue().size()
            );
        }

        executor.shutdown();
    }
}