package ru.jm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.jm.model.User;
import ru.jm.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //весь список
    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.allUser());
        return "list";
    }

    //отображение человека
    @GetMapping("/{id}")
    public String findId(@PathVariable("id")Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showId";
      }

    //форма нового пользователя
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser",new User());
        return "create";
    }

    //список с новым пользователем
    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    //форма редактирования
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")long id) {
        model.addAttribute("user",userService.getById(id));
        return "edit";
    }
    //запрос редактирования
    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id,user);
        return "redirect:/users";
    }
    //удалить пользователя
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")long id) {
        userService.remove(id);
        return "redirect:/users";
    }

}
