package DesignPattern;

interface Coffee {
    int cost();
}

class SimpleCoffee implements Coffee {
    @Override
    public int cost() {
        return 100;
    }
}

abstract class CoffeeDecorator implements Coffee {

    Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public int cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator {

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 50;
    }
}

public class Decorator {
    public static void start() {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println("Coffee Cost : " + coffee.cost());

    }
}