package ru.jm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.jm.model.Role;
import ru.jm.model.User;
import ru.jm.service.RoleService;
import ru.jm.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;



    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //весь список
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.allUser());
        return "admin/list";
    }

    //отображение человека
    @GetMapping("/{id}")
    public String findId(@PathVariable("id")Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "admin/showId";
      }

    //форма нового пользователя
    @GetMapping("/create")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        List<Role> listRoles = roleService.allRole();
        model.addAttribute("listRoles",listRoles);
        return "admin/create";
    }

    //список с новым пользователем
    @PostMapping("/create")
    public String addUser(@RequestParam("idRoles")List<Long> idRoles,
                          User user) {
       Set<Role> roleList = new HashSet<>();
       for(Long id:idRoles) {
           roleList.add(roleService.findById(id));
       }
       user.setRoles(roleList);
       userService.add(user);
       return "redirect:/admin/users";
    }

    //форма редактирования
    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id")long id) {
        model.addAttribute("user",userService.getById(id));
        return "admin/edit";
    }

    //запрос редактирования
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin/users";
    }

    //удалить пользователя
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")long id) {
        userService.remove(id);
        return "redirect:/admin/users";
    }

}
