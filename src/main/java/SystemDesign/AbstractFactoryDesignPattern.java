package SystemDesign;

import java.awt.*;

interface Button{
    void createButton();
}
interface Checkbox{
    void createCheckbox();
}

class MacButton implements Button {
    public void createButton() {
        System.out.println("Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void createCheckbox() {
        System.out.println("Mac Checkbox");
    }
}
class WindowsButton implements Button {
    public void createButton() {
        System.out.println("Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void createCheckbox() {
        System.out.println("Windows Checkbox");
    }
}

interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}

class MacFactory implements GUIFactory {

    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class WindowsFactory implements GUIFactory {

    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}


public class AbstractFactoryDesignPattern {
    private Button button;
    private Checkbox checkbox;

    public AbstractFactoryDesignPattern(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.createButton();
        checkbox.createCheckbox();
    }
    public static void start(){
        GUIFactory factory = new MacFactory();

        AbstractFactoryDesignPattern app = new AbstractFactoryDesignPattern(factory);

        app.render();
    }

}