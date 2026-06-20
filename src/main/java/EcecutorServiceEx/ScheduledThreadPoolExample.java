package EcecutorServiceEx;

import java.util.concurrent.*;

public class ScheduledThreadPoolExample {
    public static void start(){
        ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(2);

        threadPoolExecutor.schedule(()->{
            System.out.println("Executed By" + Thread.currentThread().getName());
        },5, TimeUnit.SECONDS);
    }
}