package src.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.domain.User;
import src.repositories.interfaces.IUserRepository;
import src.services.interfaces.ITestService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Teun on 7-10-2018.
 */
@Service
public class TestService implements ITestService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public Optional<String> getGreeting() {
        return Optional.of("Greetings from Test Service");
    }

    @Override
    public Optional<List<User>> testQuery() {
        return userRepository.GetAllUsers();
    }

}
