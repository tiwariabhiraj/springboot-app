package com.example.demo;

class PrintNumber {

    private int number = 1;

    public synchronized void printOdd() {
        while (true) {
            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " : " + number);
            number++;

            notify();
        }

    }

    public synchronized void printEven() {
        while (true) {
            while (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " : " + number);
            number++;
            notify();
        }

    }
}

public class ThreadCommunication {

    public static void start() {

        PrintNumber printNumber = new PrintNumber();

        Thread t1 = new Thread(() -> printNumber.printOdd(), "Odd Thread");
        Thread t2 = new Thread(() -> printNumber.printEven(), "Even Thread");

        t1.start();
        t2.start();
    }
}