package src.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teun on 7-10-2018.
 */
@RestController
public class TestController {
    @RequestMapping("/")
    public String index() {
        return "Basic Setup Complete";
    }
}
