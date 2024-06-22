package com.wanyua.Log.in.Controller;

import com.wanyua.Log.in.Entity.User;
import com.wanyua.Log.in.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("Register request: " + user);
        User registeredUser = userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser == null ? "errorPage" : "redirect/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        System.out.println("Login request: " + user);
        User authenticated = userService.authentication(user.getLogin(), user.getPassword());
        if(authenticated != null){
            return "personal";
        }
        else{
            return "errorPage";
        }
    }

}
