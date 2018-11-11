package src.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import src.repositories.interfaces.IDbProvider;

import java.sql.*;

/**
 * Created by Teun on 11-11-2018.
 */

@Service
public class DbProvider implements IDbProvider {
    Connection connection;

    public DbProvider(){
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tutorials", "postgres", "0000");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                return resultSet;
            } catch (Exception e) {
                return null;
            }
        } else {
            System.out.println("Failed to establish connection to db");
            return null;
        }
    }
}
