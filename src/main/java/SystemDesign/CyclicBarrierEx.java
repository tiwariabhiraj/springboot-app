package SystemDesign;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
    public static void start() {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads reached barrier, let's proceed!");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                barrier.await(); // wait here
            } catch (Exception e) {
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(task).start();
        }
    }
}