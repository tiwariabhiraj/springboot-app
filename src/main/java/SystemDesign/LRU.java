package SystemDesign;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int limit;

    public LRUCache(int limit) {
        super(limit, 0.75f, true); // true = access order
        this.limit = limit;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}

public class LRU {

    public static void start() {

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache);

        cache.get(1); // Access 1 (moves to recent)

        cache.put(4, "D"); // Removes least recently used

        System.out.println(cache);
    }
}