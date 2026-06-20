package com.example.demo;

import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class TestCode {


    public static void start()  {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(3000);
            return "Task Completed";
        });

        System.out.println("Doing other work...");

        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
        System.out.println("Done");

        executor.shutdown();
    }

}