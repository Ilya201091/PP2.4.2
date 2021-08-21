package DAO;

import model.User;

import java.util.List;

public interface UserDAO {

    List<User> allUser();
    void add(User user);
    void edit(User user);
    User getById(long id);
}
