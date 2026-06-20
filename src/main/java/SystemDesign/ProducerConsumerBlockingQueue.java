package SystemDesign;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable{
    BlockingQueue<Integer> queue ;
    Producer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> queue;
    Consumer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Consumed : " + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ProducerConsumerBlockingQueue {

    public static void start(){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5) ;
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

    }
}