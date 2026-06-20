package SystemDesign;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java21Featurs {
//    Virtual Threads ⭐⭐⭐⭐⭐

//    Pattern Matching Switch

    //Object obj = "Hello";
    //
    //switch (obj) {
    //
    //        case String s ->
    //                System.out.println(
    //                        "Length = " + s.length());
    //
    //        case Integer i ->
    //                System.out.println(
    //                        "Double = " + (i * 2));
    //
    //        default ->
    //                System.out.println("Unknown");
    //    }

// Record Pattern

    //    record Address(
    //            String city,
    //            String country) {
    //    }
    //
    //    record Employee(
    //            String name,
    //            int age,
    //            Address address) {
    //    }
    //    public class RecordPatternDemo {
    //
    //        public static void main(String[] args) {
    //
    //            Object obj =
    //                    new Employee(
    //                            "Abhishek",
    //                            30,
    //                            new Address(
    //                                    "Lucknow",
    //                                    "India"));
    //
    //            if (obj instanceof Employee(
    //                    String name,
    //                    int age,
    //                    Address(
    //                            String city,
    //                            String country))) {
    //
    //                System.out.println("Name    : " + name);
    //                System.out.println("Age     : " + age);
    //                System.out.println("City    : " + city);
    //                System.out.println("Country : " + country);
    //            }
    //        }
    //    }


    // Structured Concurrency

        //         try (var scope =
        //            new StructuredTaskScope.ShutdownOnFailure()) {
        //
        //        var user =
        //                scope.fork(() -> getUser());
        //
        //        var order =
        //                scope.fork(() -> getOrder());
        //
        //        scope.join();
        //
        //        scope.throwIfFailed();
        //
        //        System.out.println(user.get());
        //
        //        System.out.println(order.get());
        //    }
        //}

    // Sequenced Collections


}