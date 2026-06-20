package SystemDesign;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void start(){
        Semaphore semaphore = new Semaphore(3); // 3 permits
        Runnable task = () -> {
            try {
                semaphore.acquire(); // take permit
                System.out.println(Thread.currentThread().getName() + " using resource");
                Thread.sleep(2000);
            } catch (Exception e) {
            } finally {
                semaphore.release(); // release permit
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(task).start();

        }
    }
}