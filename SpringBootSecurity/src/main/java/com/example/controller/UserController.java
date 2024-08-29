package com.example.controller;



import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(ModelMap model) {
        return "user";
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("course") Integer course,
                          @RequestParam("email") String email,
                          ModelMap model) {
        User usersAdd = new User(name, course, email);

        User userAdd = userService.addUser(usersAdd);
        model.addAttribute("user", userAdd);
        return "user";

    }

    @PostMapping("/id")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("course") Integer course,
                             @RequestParam("email") String email, ModelMap model) {
        User updateUser = new User(name, course, email);
        userService.updateUser(id, updateUser);
        model.addAttribute("user", updateUser);
        return "user";

    }

    @GetMapping("/read/id")
    public String readUser(@RequestParam("id") Long id, ModelMap model) {

        User findUserId = userService.findByIdUser(id);
        model.addAttribute("user", findUserId);
        return "user";

    }

    @GetMapping("/read")
    public String readAllUser(ModelMap model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "user";

    }

    @GetMapping("/delete/id")
    public String deleteUser(@RequestParam("id") Long id, ModelMap model) {
        userService.deleteUser(id);
        model.addAttribute("user");
        return "user";

    }
}
