package SystemDesign;

import java.util.PriorityQueue;

class Server {
    String name;
    int load;

    public Server(String name) {
        this.name = name;
        this.load = 0;
    }

    @Override
    public String toString() {
        return name + "(load=" + load + ")";
    }
}

public class LoadBalancer {

    private final PriorityQueue<Server> pq =
            new PriorityQueue<>((a, b) -> {
                if (a.load != b.load) {
                    return Integer.compare(a.load, b.load);
                }
                return a.name.compareTo(b.name);
            });

    public void addServer(String name) {
        pq.offer(new Server(name));
    }

    public Server assignRequest() {

        if (pq.isEmpty()) {
            throw new RuntimeException("No server available");
        }

        Server server = pq.poll();

        server.load++;

        pq.offer(server);

        return server;
    }

    public void completeRequest(String serverName) {

        Server target = null;

        for (Server s : pq) {
            if (s.name.equals(serverName)) {
                target = s;
                break;
            }
        }

        if (target == null) {
            return;
        }

        pq.remove(target);

        target.load--;

        pq.offer(target);
    }

    public void printServers() {
        System.out.println("Current Server Status:");

        for (Server server : pq) {
            System.out.println(server);
        }

        System.out.println("-------------------");
    }

    public static void main(String[] args) {

        LoadBalancer lb = new LoadBalancer();

        lb.addServer("Server-A");
        lb.addServer("Server-B");
        lb.addServer("Server-C");

        lb.printServers();

        System.out.println("Request 1 -> " + lb.assignRequest());
        System.out.println("Request 2 -> " + lb.assignRequest());
        System.out.println("Request 3 -> " + lb.assignRequest());
        System.out.println("Request 4 -> " + lb.assignRequest());
        System.out.println("Request 5 -> " + lb.assignRequest());

        lb.printServers();

        System.out.println("Completing request on Server-A");
        lb.completeRequest("Server-A");

        lb.printServers();

        System.out.println("Next Request -> " + lb.assignRequest());

        lb.printServers();
    }
}