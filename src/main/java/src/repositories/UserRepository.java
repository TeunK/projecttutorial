package src.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import src.domain.User;
import src.repositories.interfaces.IDbProvider;
import src.repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Teun on 11-11-2018.
 */
@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    DbProvider dbProvider;

    @Override
    public Optional<List<User>> GetAllUsers() {
        try {
            ResultSet resultSet = dbProvider.executeQuery("SELECT id, name FROM abdinasir.users");

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
