package src.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.domain.User;
import src.services.interfaces.ITestService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Teun on 7-10-2018.
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @RequestMapping("/")
    public String index() {
        Optional<String> greetingOptional = testService.getGreeting();
        if (greetingOptional.isPresent()) {
            return greetingOptional.get();
        } else {
            return "No thing to see here";
        }
    }

    @RequestMapping("/testdb")
    public List<User> testDb() {
        Optional<List<User>> usersOptional = testService.testQuery();
        if (usersOptional.isPresent()) {
            return usersOptional.get();
        } else {
            return null;
        }
    }
}
