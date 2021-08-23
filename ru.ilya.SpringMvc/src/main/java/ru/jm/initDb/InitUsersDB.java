package ru.jm.initDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jm.model.User;
import ru.jm.service.UserService;


import javax.annotation.PostConstruct;

@Component
public class InitUsersDB {

    private UserService userService;

    @Autowired
    public InitUsersDB(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initApiUserData() {
        User user1 = new User("Andrey","Gorbunov",(byte)30 );
        User user2 = new User("Olga","Gorbunova",(byte) 50);
        userService.add(user1);
        userService.add(user2);
    }
}
