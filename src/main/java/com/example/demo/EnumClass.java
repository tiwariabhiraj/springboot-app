package com.example.demo;

enum PaymentStatus {
    SUCCESS(200, "Payment successful"),
    FAILED(500, "Payment failed"),
    PENDING(100, "Payment pending");

    private int code;
    private String message;

    // Constructor (called once per constant)
    PaymentStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // Getter
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    // Custom method
    public boolean isSuccess() {
        return this == SUCCESS;
    }

    // Static utility method (VERY IMPORTANT)
    public static PaymentStatus fromCode(int code) {
        for (PaymentStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}

public class EnumClass {
    public static void start() {

        // 1. Assign enum
        PaymentStatus status = PaymentStatus.SUCCESS;

        // 2. Access fields
        System.out.println(status); // SUCCESS
        System.out.println(status.getCode()); // 200
        System.out.println(status.getMessage()); // Payment successful

        // 3. Custom logic
        if (status.isSuccess()) {
            System.out.println("Proceed further...");
        }

        // 4. Convert from code → enum
        PaymentStatus s = PaymentStatus.fromCode(500);
        System.out.println(s); // FAILED

        // 5. Loop all values
        for (PaymentStatus ps : PaymentStatus.values()) {
            System.out.println(ps + " -> " + ps.getCode());
        }
    }
}