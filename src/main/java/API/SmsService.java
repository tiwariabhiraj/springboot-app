package API;

import API.AppService;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements AppService {

    @Override
    public String getMessage() {
        return "SMS Service";
    }
}