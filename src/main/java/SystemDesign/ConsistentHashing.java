package SystemDesign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

class ConsistentHashingRing {

    private final TreeMap<Long, String> ring = new TreeMap<>();
    private final int numberOfReplicas;

    public ConsistentHashingRing(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    // Better hash function using MD5
    private long hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            long hash = 0;
            for (int i = 0; i < 4; i++) {
                hash <<= 8;
                hash |= ((int) digest[i]) & 0xFF;
            }
            return hash & 0xffffffffL;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Add server with virtual nodes
    public void addServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            long hash = hash(server + "#" + i);
            ring.put(hash, server);
        }
    }

    // Remove server
    public void removeServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            long hash = hash(server + "#" + i);
            ring.remove(hash);
        }
    }

    // Find server for key
    public String getServer(String key) {
        if (ring.isEmpty()) {
            return null;
        }
        long hash = hash(key);
        Long serverHash = ring.ceilingKey(hash);
        if (serverHash == null) {
            serverHash = ring.firstKey();
        }
        return ring.get(serverHash);
    }
}

public class ConsistentHashing {

    public static void start() {

        ConsistentHashingRing ch = new ConsistentHashingRing(100);

        ch.addServer("Server1");
        ch.addServer("Server2");
        ch.addServer("Server3");

        System.out.println("user1 -> " + ch.getServer("user1"));
        System.out.println("user2 -> " + ch.getServer("user2"));
        System.out.println("user3 -> " + ch.getServer("user3"));
        System.out.println("user4 -> " + ch.getServer("user4"));
        System.out.println("user5 -> " + ch.getServer("user5"));
    }
}