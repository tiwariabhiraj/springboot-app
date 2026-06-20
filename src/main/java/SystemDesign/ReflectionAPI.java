package SystemDesign;

import org.springframework.beans.factory.annotation.Autowired;

public class ReflectionAPI {
    //@Autowired
        //    class OrderService {
        //        @Autowired
        //        private UserService userService;
        //    }

    // Dynamic Bean Creation
        // Class<?> clazz = Class.forName("com.app.UserService");
        // Object obj = clazz.getDeclaredConstructor().newInstance();

    // AOP (Aspect-Oriented Programming)
        // @Transactional
        // public void process() { }

    //Testing Frameworks (JUnit / Mockito)
        // @InjectMocks
        // OrderService orderService;

        // @Mock
        // UserService userService;

    // JSON Conversion (Jackson)
        // ObjectMapper mapper = new ObjectMapper();
        // User user = mapper.readValue(json, User.class);

    // Hibernet/JPA
        // @Entity
        // class User {
            // private String name;
        // }


}