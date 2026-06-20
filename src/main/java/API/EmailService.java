package API;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements AppService {

    @Override
    public String getMessage() {
        return "Email Service";
    }
}