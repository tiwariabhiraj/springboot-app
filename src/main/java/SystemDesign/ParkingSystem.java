package SystemDesign;
enum VEHICLE_TYPE{
    CAR,
    BIKE,
    TRUCK
}
class VehicleInformation {
    String VehicleId;
    VEHICLE_TYPE type;
}

class Bookings {
    String VehicleId;
    String SlotNumber;
    String PaymentStatus;
    Long entryTime;
    Long exitTime;
}

class BookingSlot {
    Integer slotNumber;
    Integer floorNumber;
    Boolean status;
    Boolean isAvailable;
    VEHICLE_TYPE type;
}

class Payment {
    String BookingId;
    String PaymentStatus;
    String PaymentMode;
}

public class ParkingSystem {
    public static void start(){

    }
}