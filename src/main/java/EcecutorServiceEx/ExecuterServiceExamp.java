package EcecutorServiceEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceExamp {

    public static void start(){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println("Task executed by " + Thread.currentThread().getName());
        };

        for(int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        executor.shutdown();    }
}