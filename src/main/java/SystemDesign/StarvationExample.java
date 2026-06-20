package SystemDesign;
class Worker extends Thread {

    public Worker(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " running");
        }
    }
}

public class StarvationExample {
    public static void start(){
        Worker t1 = new Worker("HighPriority", Thread.MAX_PRIORITY);
        Worker t2 = new Worker("LowPriority", Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}