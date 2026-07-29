package SystemDesign;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/* ==========================
        ENUMS
========================== */

enum VehicleType {
    CAR, BIKE, BUS, TRUCK
}

enum PaymentType {
    CASH, UPI, CARD
}

enum BookingStatus {
    ACTIVE,
    COMPLETED,
    CANCELLED
}

enum PaymentStatus {
    PENDING,
    SUCCESS,
    FAILED
}

/* ==========================
     FEE STRATEGY
========================== */

interface FeeStrategy {
    double calculateFee(long hours);
}

class CarFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(long hours) {
        return hours * 10;
    }
}

class BikeFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(long hours) {
        return hours * 5;
    }
}

class BusFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(long hours) {
        return hours * 15;
    }
}

class TruckFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(long hours) {
        return hours * 20;
    }
}

/* ==========================
   PAYMENT STRATEGY
========================== */

interface PaymentStrategy {
    void pay(double amount);
}



class CashPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Cash Payment : ₹" + amount);
    }
}

class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Card Payment : ₹" + amount);
    }
}

class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment : ₹" + amount);
    }
}

/* ==========================
     PAYMENT SERVICE
========================== */

class PaymentService {

    private final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

/* ==========================
        ENTITIES
========================== */

@Data
class Vehicle {

    private String id = UUID.randomUUID().toString();

    private VehicleType type;

    private String slotId;

    private String vehicleNumber;
}

@Data
class Slot {

    private String id = UUID.randomUUID().toString();

    private Integer floorNumber;

    private Boolean available;

    private Long slotNumber;
}

@Data
class Payments {

    private String id = UUID.randomUUID().toString();

    private String bookingId;

    private PaymentStatus paymentStatus;

    private LocalDateTime paymentTime;

    private PaymentType paymentType;
}

@Data
class Booking {

    private String id = UUID.randomUUID().toString();

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private String vehicleId;

    private String slotId;

    private BookingStatus bookingStatus;

    private String paymentId;
}

/* ==========================
      PARKING LOT
========================== */

public class ParkingLot {

    public static void start() {

        // Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setType(VehicleType.CAR);
        vehicle.setVehicleNumber("DL01AB1234");

        // Fee Calculation
        FeeStrategy feeStrategy = new CarFeeStrategy();

        double amount = feeStrategy.calculateFee(5);

        System.out.println("Parking Fee : ₹" + amount);

        // Payment
        PaymentStrategy paymentStrategy = new UpiPayment();

        PaymentService paymentService = new PaymentService(paymentStrategy);

        paymentService.processPayment(amount);
    }

    public static void entryVehicle() {

    }

    public static void exitVehicle() {

    }

    public static void main(String[] args) {
        start();
    }
}