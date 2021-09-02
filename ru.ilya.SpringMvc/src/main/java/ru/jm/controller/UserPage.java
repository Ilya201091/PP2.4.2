package ru.jm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.jm.model.User;
import ru.jm.service.RoleService;
import ru.jm.service.UserService;



@Controller
public class UserPage {


    private final UserService userService;

    @Autowired
    public UserPage(RoleService roleService, UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String pageMain() {
        return "user/mainPage";
    }

    @GetMapping(value = "/user")
    public String getUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "user/userShowId";
    }
    



}
