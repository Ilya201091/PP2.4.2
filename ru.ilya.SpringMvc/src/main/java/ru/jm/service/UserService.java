package ru.jm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.jm.model.Role;
import ru.jm.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUser();
    void add(User user);
    User getById(long id);
    void update(User user);
    void remove(long id);
    Role getRole(String role);
}
