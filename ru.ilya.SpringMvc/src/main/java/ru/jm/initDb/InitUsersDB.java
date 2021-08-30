package ru.jm.initDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jm.model.Role;
import ru.jm.model.User;
import ru.jm.service.RoleService;
import ru.jm.service.UserService;


import javax.annotation.PostConstruct;
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

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);                      //Andrey
        User user1 = new User("Andrey","{bcrypt}$2y$10$k6hAHt35z833A2XXqAEDjOdfYLyCMgl/Q6CtLWvBTH.oaD8ZGol4y",
                "andey@ya.ru", (byte) 53);
        user1.setRoles((Set<Role>) roleAdmin);
                                                           //Olga
        User user2 = new User("Olga","{bcrypt}$2y$10$3ByryyEPK.gYqgpKHI0XL.ZQYXKhd34fvjdjDo/zJndKyoTYwjHe2",
                "olga@mail.ru",(byte) 50);
        user2.setRoles((Set<Role>)roleUser);
        userService.add(user1);
        userService.add(user2);
    }
}
