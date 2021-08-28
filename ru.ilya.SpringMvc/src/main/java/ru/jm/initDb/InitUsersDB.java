package ru.jm.initDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jm.model.Role;
import ru.jm.model.User;
import ru.jm.service.UserService;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Component
public class InitUsersDB {

    private UserService userService;

    @Autowired
    public InitUsersDB(UserService userService) {
        this.userService = userService;
    }

    Role roleAdmin = new Role("ROLE_ADMIN");
    Role roleUser = new Role("ROLE_USER")

    @PostConstruct
    public void initApiUserData() {
        User user1 = new User("Andrey","$2a$12$IbrQqbVaY7qB.ylZKU1yYusjWvUi6iGfkrPjv5nEGGhplba/VBpA2",
                "andey@ya.ru",53);
        User user2 = new User("Olga","Gorbunova",(byte) 50);
        userService.add(user1);
        userService.add(user2);
    }
}
