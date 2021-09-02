package ru.jm.initDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jm.model.Role;
import ru.jm.model.User;
import ru.jm.service.RoleService;
import ru.jm.service.UserService;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUsersDB {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitUsersDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initApiUserData() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> rolesForAdmin = new HashSet<>();
        Set<Role> rolesForUser = new HashSet<>();

        rolesForAdmin.add(roleAdmin);
        rolesForAdmin.add(roleUser);

        rolesForUser.add(roleUser);

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);
        User user1 = new User("Andrey","Andrey",
                "andey@ya.ru", (byte) 53);
        user1.setRoles(rolesForAdmin);
        User user2 = new User("Olga","Olga",
                "olga@mail.ru",(byte) 50);
        user2.setRoles(rolesForUser);
        userService.add(user1);
        userService.add(user2);
    }
}
