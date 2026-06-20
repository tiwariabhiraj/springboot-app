package com.example.demo;

class Deadlock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void startThread(Object a, Object b) {
        synchronized (a) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}

            synchronized (b) {
                System.out.println("Done");
            }
        }
    }

    public void start() {

        Thread t1 = new Thread(() -> startThread(lock1, lock2));
        Thread t2 = new Thread(() -> startThread(lock2, lock1));

        t1.start();
        t2.start();
    }
}