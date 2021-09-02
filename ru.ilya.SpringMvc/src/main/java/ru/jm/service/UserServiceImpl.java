package ru.jm.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.jm.DAO.UserDAO;
import ru.jm.model.Role;
import ru.jm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{


    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> allUser() {
        return userDAO.allUser();
    }

    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.add(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(User user){
        userDAO.update(user);
    }
    @Override
    public void remove(long id) {
        userDAO.remove(id);
    }

    @Override
    public Role getRole(String role) {
        return userDAO.getRole(role);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.getUserByName(s);
        if(user == null) {
            throw new UsernameNotFoundException("User with name" + s);
        }
        return user;
    }
}
