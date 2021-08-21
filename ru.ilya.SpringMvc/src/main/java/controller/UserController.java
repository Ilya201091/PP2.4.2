package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.allUser());
        return "list";
    }

    @GetMapping("/{id}")
    public String findId(@PathVariable("id")Long id,Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showId";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "create";
    }


}
