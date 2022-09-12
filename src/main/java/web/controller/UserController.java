package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/create")
    public String showAddUser() {
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute ("user") User user) {
        userService.add(user);
        return "index";
    }
    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users",users);
        return "index";
    }



}
