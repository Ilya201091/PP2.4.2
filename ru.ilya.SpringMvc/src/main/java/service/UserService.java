package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    void add(User user);
    void edit(User user);
    User getById(int id);
}
