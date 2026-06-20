package SystemDesign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
class Users {
    public String name;
    public String message;
    public String status;
}
public class Java17Feature {

    // Records
    record User(String name, int age) {}

    // Sealed class
    sealed class Vehicle permits Car, Bike {}
    final class Car extends Vehicle {}
    final class Bike extends Vehicle {}

    //Pattern Matching for instanceof ====================================
//    if (obj instanceof String s) {  // NEW
//        System.out.println(s.length());
//    }
//    if (obj instanceof String) {  // OLD
//        String s = (String) obj;
//    }


//    Pattern Matching for switch (Preview)===============================
//    Object obj = "Hello";
//switch (obj) {
//        case String s -> System.out.println("String: " + s);
//        case Integer i -> System.out.println("Integer: " + i);
//        default -> {}
//    }

    // New Random API
//    RandomGenerator r = RandomGenerator.getDefault();
//    int num = r.nextInt();'

    // MultiLine String

    public static void start() throws Exception {
        String text = """
                Hello 
                World
                """;
        System.out.println(text);
        String name = "Abhishek";
        String message = "Welcome to our platform";

        String payload = """
        {
            "name": "%s",
            "message": "%s",
            "status": "ACTIVE"
        }
        """.formatted(name, message);

        System.out.println(payload);
        //1st
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(payload);
        String nameVa = jsonNode.get("name").asText();
        System.out.println(nameVa);

        //2nd Method
        Users user = mapper.readValue(payload, Users.class);
        System.out.println(user.name); // Abhishek
    }
}
