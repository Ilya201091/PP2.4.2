package ru.jm.service;

import ru.jm.DAO.UserDAO;
import ru.jm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> allUser() {
        return userDAO.allUser();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(long id,User user){
        userDAO.update(id,user);
    }
    @Override
    public void remove(long id) {
        userDAO.remove(id);
    }
}
