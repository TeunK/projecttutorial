package src.repositories.interfaces;

import src.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Teun on 11-11-2018.
 */
public interface IUserRepository {
    Optional<List<User>> GetAllUsers();
}
