package src.services;

import org.springframework.stereotype.Service;
import src.services.interfaces.ITestService;

/**
 * Created by Teun on 7-10-2018.
 */
@Service
public class TestService implements ITestService {

    @Override
    public String getGreeting() {
        return "Greetings from Test Service";
    }

}
