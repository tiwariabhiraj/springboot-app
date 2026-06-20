package EcecutorServiceEx;

class TestThreadInterrupt implements Runnable{
private int counter=0;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted, stopping...");
                break;
            }

            System.out.println("Counter " + counter++);

            try {
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println("Sleep interrupted");
                Thread.currentThread().interrupt(); // restore interrupt flag
            }
        }
    }
}

public class ThreadInterrupt {
    public static void start(){
        TestThreadInterrupt threadInterrupt = new TestThreadInterrupt();
        Thread t1 = new Thread(threadInterrupt);
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.interrupt();
    }
}