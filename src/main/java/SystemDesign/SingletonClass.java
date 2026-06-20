package SystemDesign;
import java.io.Serializable;

public class SingletonClass implements Serializable, Cloneable {

    private static volatile SingletonClass instance;

    private SingletonClass() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance()");
        }
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    // Prevent serialization issue
    protected Object readResolve() {
        return instance;
    }

    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed");
    }
}