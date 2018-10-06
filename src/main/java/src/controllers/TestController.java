package src.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.services.interfaces.ITestService;

/**
 * Created by Teun on 7-10-2018.
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @RequestMapping("/")
    public String index() {
        String result = testService.getGreeting();
        return result;
    }
}
