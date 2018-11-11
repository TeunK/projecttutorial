package src.repositories.interfaces;

import java.sql.ResultSet;

/**
 * Created by Teun on 11-11-2018.
 */
public interface IDbProvider {
    ResultSet executeQuery(String query);
}
