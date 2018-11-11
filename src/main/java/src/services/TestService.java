package src.services;

import org.springframework.stereotype.Service;
import src.domain.User;
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

    @Override
    public Optional<String> getGreeting() {
        return Optional.of("Greetings from Test Service");
    }

    @Override
    public Optional<List<User>> testQuery() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tutorials", "postgres", "0000");
            PreparedStatement statement = connection.prepareStatement("SELECT id, name FROM abdinasir.users");
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.id = resultSet.getInt(1);
                user.name = resultSet.getString(2);
                users.add(user);
            }

            return Optional.of(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

}
