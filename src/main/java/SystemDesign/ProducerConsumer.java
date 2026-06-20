package SystemDesign;
class ProducerConsumerService {
    private String message;

    public synchronized void produce(){
        while (true){
            if(message!=null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            message = "Message Timestamp : " + System.currentTimeMillis();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify();
        }

    }

    public synchronized void consume(){
        while (true){
            if(message==null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Consumed Data : " + message);
            message = null;
            notify();
        }


    }
}


public class ProducerConsumer {
    public static void start() {
        ProducerConsumerService producerConsumerService = new ProducerConsumerService();
        Runnable producer = producerConsumerService::produce;
        Runnable consumer = producerConsumerService::consume;

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();


    }
}