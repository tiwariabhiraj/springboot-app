    package SystemDesign;

    enum Singleton {

        INSTANCE;

        // Example field
        private String value;

        // Example method
        public void doSomething() {
            System.out.println("Doing something...");
        }

        // Getter & Setter
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public class SingletonEnum {
        public static void start() {

            Singleton obj1 = Singleton.INSTANCE;
            Singleton obj2 = Singleton.INSTANCE;

            obj1.setValue("Hello Singleton");

            System.out.println(obj2.getValue()); // Same instance
            obj1.doSomething();
        }
    }