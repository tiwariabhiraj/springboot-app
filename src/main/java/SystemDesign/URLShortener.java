package SystemDesign;

import java.util.concurrent.atomic.AtomicInteger;

public class URLShortener {

    private static final String STRING_RANGE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static String shortUrl(String url) {

        int id = atomicInteger.getAndIncrement();
        StringBuilder shortUrl = new StringBuilder();

        while (id > 0) {
            int remainder = id % 62;
            shortUrl.append(STRING_RANGE.charAt(remainder));
            id = id / 62;
        }

        return shortUrl.reverse().toString();
    }

    public static void start() {
        String shortURL = URLShortener.shortUrl("www.google.com");
        String shortURL1 = URLShortener.shortUrl("www.google.com1");

        System.out.println("Short URL: " + shortURL + shortURL1);
    }

    public static void main(String[] args) {
        start();
    }
}