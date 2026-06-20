package SystemDesign;

class Spoon {

    private Diner owner;

    public Spoon(Diner d) {
        owner = d;
    }

    public synchronized void setOwner(Diner d) {
        owner = d;
    }

    public synchronized void use() {
        System.out.println(owner.name + " is eating");
    }

    public Diner getOwner() {
        return owner;
    }
}

class Diner {

    String name;
    boolean isHungry = true;

    public Diner(String name) {
        this.name = name;
    }

    public void eatWith(Spoon spoon, Diner spouse) {

        while (isHungry) {

            if (spoon.getOwner() != this) {
                continue;
            }

            if (spouse.isHungry) {
                System.out.println(name + ": You eat first " + spouse.name);
                spoon.setOwner(spouse);
                continue;
            }

            spoon.use();
            isHungry = false;

            System.out.println(name + ": I am done eating");
            spoon.setOwner(spouse);
        }
    }
}

public class LivelockExample {

    public static void start() {

        Diner husband = new Diner("Husband");
        Diner wife = new Diner("Wife");

        Spoon spoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();
    }
}