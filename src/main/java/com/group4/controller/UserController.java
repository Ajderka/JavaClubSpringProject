package com.group4.controller;
import com.group4.model.User;
import com.group4.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUser(Model model) {
        model.addAttribute("users", this.userService.listUser());
        return "list-users";
    }

    @GetMapping("/add")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/add")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()){
            return "create-user";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }
//
//    @PostMapping("/user-update")
//    public String updateUser(User user) {
//        userService.saveUser(user);
//        return "redirect:/users";
//    }



}
