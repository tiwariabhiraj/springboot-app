package SystemDesign;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class RateLimiterSlidingWindowConfig {

    private int limit;
    private long windowSize;
    private Map<String, LinkedList<Long>> windowList = new HashMap<>();

    RateLimiterSlidingWindowConfig(int limit, int windowSizeSeconds) {
        this.limit = limit;
        this.windowSize = windowSizeSeconds * 1000L;
    }

    public synchronized boolean isValid(String userId) {

        long currentTime = System.currentTimeMillis();

        LinkedList<Long> userRequests = windowList.computeIfAbsent(userId, k -> new LinkedList<>());

        // Remove expired timestamps
        while (!userRequests.isEmpty() && currentTime - userRequests.peek() > windowSize) {
            userRequests.poll();
        }

        // Check request limit
        if (userRequests.size() >= limit) {
            return false;
        }

        // Add current request
        userRequests.add(currentTime);

        return true;
    }
}
public class RateLimiterSliding {
    public static void start(){
        RateLimiterSlidingWindowConfig limiter = new RateLimiterSlidingWindowConfig(3, 10);

        for (int i = 1; i <= 10; i++) {

            boolean allowed = limiter.isValid("user1");

            System.out.println("Request " + i + " allowed: " + allowed);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}