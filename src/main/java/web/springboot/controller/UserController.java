package web.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.springboot.model.User;
import web.springboot.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAllPeople(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/all";
    }

    @GetMapping("/particular")
    public String getParticularUser(@RequestParam("id") Long id, Model model) {
        User user = userService.getParticularUser(id);
        model.addAttribute("user", user);
        return "users/particular";
    }

    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.addNewUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/edit")
    public String updateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getParticularUser(id));
        return "users/edit";
    }

    @PostMapping("/particular")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users/all";
    }

    @PostMapping("/particular/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users/all";
    }
}
