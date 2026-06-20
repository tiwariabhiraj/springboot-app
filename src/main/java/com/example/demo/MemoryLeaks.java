package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryLeaks {
    private static List<String> list = new ArrayList<>();

    public static void start() throws FileNotFoundException {
        // first
//        while (true) {
//            list.add("Abhishek Tiwari");
//        }

        // second
        FileInputStream fis = new FileInputStream("test.txt"); // resource not closed

        // third
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("UserData");
        threadLocal.remove(); // you need to do that
        // fourth
        Map<Integer, String> cache = new HashMap<>();

        for(int i=0; i<1000000; i++){
            cache.put(i, "data");
        }

        // Fifth
//        private List<WebSocket.Listener> listeners = new ArrayList<>();
//
//        public void register(WebSocket.Listener l){
//            listeners.add(l);
//        }
    }
}