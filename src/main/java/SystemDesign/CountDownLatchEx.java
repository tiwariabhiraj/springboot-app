package SystemDesign;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    public static void start() {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println("Payment processed");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Inventory reserved");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Notification sent");
            latch.countDown();
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Order confirmed");
    }
}