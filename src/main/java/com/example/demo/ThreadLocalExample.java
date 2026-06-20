package com.example.demo;

public class ThreadLocalExample {
    private static ThreadLocal<String> user = ThreadLocal.withInitial(() -> "Unknown");
    public static void start() {
        Runnable task = () -> {
            user.set(Thread.currentThread().getName());
            System.out.println(user.get());
        };
        // ThreadLocal creates separate copies for each thread.
        new Thread(task).start();
        new Thread(task).start();
    }
}