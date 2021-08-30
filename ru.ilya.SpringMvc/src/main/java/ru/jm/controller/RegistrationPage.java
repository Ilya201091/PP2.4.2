package ru.jm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.jm.service.RoleService;
import ru.jm.service.UserService;

@Controller
@RequestMapping("/main")
public class RegistrationPage {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public RegistrationPage(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    //стартовая страница
    @GetMapping()
    public String startPage() {
        return "startPage";
    }

   /* //войти в свой профиль
    @GetMapping("/{id}")
    public String enterProfile(@PathVariable("id")Long id, Model model) {
        model.addAttribute("user",userService.getById(id));
        return "profile";
    }*/



}
