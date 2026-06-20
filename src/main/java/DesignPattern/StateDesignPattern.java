package DesignPattern;

interface ATMState {
    void insertCard();
    void enterPin(int pin);
    void withdrawCash(int amount);
    void ejectCard();
}

class NoCardState implements ATMState {

    private ATMMachine atm;

    public NoCardState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted.");
        atm.setState(atm.getHasCardState());
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }
}
class HasCardState implements ATMState {

    private ATMMachine atm;

    public HasCardState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(int pin) {

        if (pin == 1234) {
            System.out.println("PIN verified.");
            atm.setState(atm.getPinVerifiedState());
        } else {
            System.out.println("Wrong PIN.");
        }
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Please verify PIN first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(atm.getNoCardState());
    }
}
class PinVerifiedState implements ATMState {

    private ATMMachine atm;

    public PinVerifiedState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Transaction in progress.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("PIN already verified.");
    }

    @Override
    public void withdrawCash(int amount) {

        if (amount > atm.cash) {
            System.out.println("Insufficient ATM cash.");
            return;
        }

        atm.cash -= amount;

        System.out.println("Please collect ₹" + amount);
        System.out.println("Remaining ATM cash: ₹" + atm.cash);

        System.out.println("Card ejected.");

        atm.setState(atm.getNoCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(atm.getNoCardState());
    }
}
class ATMMachine {
    ATMState noCardState;
    ATMState hasCardState;
    ATMState pinVerifiedState;
    ATMState currentState;
    int cash = 10000;

    public ATMMachine() {
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        pinVerifiedState = new PinVerifiedState(this);
        currentState = noCardState;
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public ATMState getNoCardState() {
        return noCardState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getPinVerifiedState() {
        return pinVerifiedState;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void enterPin(int pin) {
        currentState.enterPin(pin);
    }

    public void withdrawCash(int amount) {
        currentState.withdrawCash(amount);
    }

    public void ejectCard() {
        currentState.ejectCard();
    }
}
public class StateDesignPattern {
    public static void start() {
        ATMMachine atm = new ATMMachine();

        atm.insertCard();

        atm.enterPin(1234);

        atm.withdrawCash(2000);

        System.out.println();

        atm.withdrawCash(500);

        System.out.println();

        atm.insertCard();

        atm.enterPin(9999);

        atm.withdrawCash(1000);

        atm.ejectCard();
    }
}