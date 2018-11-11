package src.services.interfaces;

import src.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Teun on 7-10-2018.
 */
public interface ITestService {
    Optional getGreeting();
    Optional<List<User>> testQuery();
}
