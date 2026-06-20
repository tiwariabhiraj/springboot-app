package SystemDesign;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Java8Feature {
    public static void start() {
        Runnable r = () -> System.out.println("Hello Lambda");
        new Thread(r).start();

        // Functional Interface

        List<Integer> list = List.of(1, 2, 3, 4, 5);

        list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

        // Method Refrence
        list.forEach(System.out::println);

        //default Method
        interface Vehicle {
            default void start() {
                System.out.println("Vehicle starting...");
            }
        }

        // Static method
        interface MathUtil {
            static int add(int a, int b) {
                return a + b;
            }
        }

        //Optional
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Default"));

        // Replace Old Date
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);

        // Completable Future
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " World")
                .thenAccept(System.out::println);
        // Parallel Stream
        list.parallelStream()
                .forEach(System.out::println);

        // Collectors
        List<String> names = list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        //ForEach
        list.forEach(x -> System.out.println(x));

        // Base64 Encoder
        String encoded = Base64.getEncoder().encodeToString("Hello".getBytes());

        // StringJoiner
        StringJoiner sj = new StringJoiner(",");
        sj.add("A").add("B").add("C");

        System.out.println(sj.toString());
    }
}