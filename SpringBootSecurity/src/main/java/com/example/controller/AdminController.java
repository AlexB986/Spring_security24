package com.example.controller;



import com.example.model.MyUser;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(ModelMap model) {
        return "user";
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          ModelMap model) {
        MyUser usersAdd = new MyUser(name, password, email);

        MyUser userAdd = userService.addUser(usersAdd);
        model.addAttribute("user", userAdd);
        return "admin";

    }

    @PostMapping("/id")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("password") String password,
                             @RequestParam("email") String email, ModelMap model) {
        MyUser updateUser = new MyUser(name, password, email);
        userService.updateUser(id, updateUser);
        model.addAttribute("user", updateUser);
        return "admin";

    }

    @GetMapping("/read/id")
    public String readUser(@RequestParam("id") Long id, ModelMap model) {

        MyUser findUserId = userService.findByIdUser(id);
        model.addAttribute("user", findUserId);
        return "admin";

    }

    @GetMapping("/read")
    public String readAllUser(ModelMap model) {
        List<MyUser> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "admin";

    }

    @GetMapping("/delete/id")
    public String deleteUser(@RequestParam("id") Long id, ModelMap model) {
        userService.deleteUser(id);
        model.addAttribute("user");
        return "admin";

    }
}
