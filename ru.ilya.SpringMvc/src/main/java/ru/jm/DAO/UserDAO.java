package ru.jm.DAO;

import ru.jm.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUser();
    void add(User user);
    void edit(User user);
    User getById(long id);
}
