package SystemDesign;

import java.util.LinkedList;
import java.util.Queue;

class RateLimiter {
    private Integer limit;
    private Queue<Long> queue;
    private Long windowSize;

    RateLimiter(Integer limit  , Long windowSize) {
        this.limit=limit;
        this.queue = new LinkedList<>();
        this.windowSize = windowSize*1000L;
    }

    public synchronized boolean allowRequest(){
        long currentTime = System.currentTimeMillis();
        while (!queue.isEmpty() && currentTime - queue.peek() > windowSize){
            queue.poll();
        }
        if(queue.size()<limit){
            queue.add(currentTime);
            return  true;
        }
        return  false;
    }
}

public class SlidingWindowRateLimiter {

    public static void start() {
        RateLimiter rateLimiter = new RateLimiter(3,10L);
        for (int i = 0; i < 15; i++) {
            boolean isAllowed = rateLimiter.allowRequest();
            System.out.println("Request " + i + " allowed: " + isAllowed);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}