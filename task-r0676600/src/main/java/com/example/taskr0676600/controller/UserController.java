package com.example.taskr0676600.controller;

import com.example.taskr0676600.domain.service.UserService;
import com.example.taskr0676600.dto.CreateUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "signinform";
    }


    @GetMapping("/signup")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new CreateUserDTO());
        return "signupform";
    }

    @PostMapping("/signup")
    public String postCreateUser(@ModelAttribute("user") @Valid CreateUserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signupform";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

}
