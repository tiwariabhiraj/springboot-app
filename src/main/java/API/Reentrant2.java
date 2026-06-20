package API;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant2 {

    ReentrantLock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        try {
            System.out.println("Outer method");
            inner();   // same thread calling inner()

        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock();  // allow only for parent thread that already have the same lock
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }
}