package API;


import java.util.concurrent.locks.ReentrantLock;

class Counter {

    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {

        lock.lock();
        try {
            count++;
            System.out.println("Modified : " + Thread.currentThread().getName() + " Count: " + count);
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockEx {
    public static void start() {
        Counter counter = new Counter();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    counter.increment();
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread1.start();
        thread.start();

    }
}