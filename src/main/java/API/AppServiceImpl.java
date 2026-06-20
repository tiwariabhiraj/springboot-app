package API;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AppServiceImpl implements AppService {

    @Override
    public String getMessage() {
        return "Hello from Spring Boot API";
    }
}