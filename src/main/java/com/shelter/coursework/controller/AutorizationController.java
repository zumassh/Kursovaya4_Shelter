package com.shelter.coursework.controller;

import com.shelter.coursework.DTO.RegistrationDTO;
import com.shelter.coursework.entity.User;
import com.shelter.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorizationController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registry";
    }

    @PostMapping("/registration")
    public ModelAndView setUser(@ModelAttribute RegistrationDTO registrationDTO){
        if (!registrationDTO.getPassword().equals(registrationDTO.getPasswordRepeat())){
            return new ModelAndView("registry", "Error", "Пароли не совпадают!");
        }
        User newUser = new User();
        newUser.setLogin(registrationDTO.getLogin());
        newUser.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        newUser.setRole("usr");

        try{
            userService.createUser(newUser);
            return new ModelAndView("login");
        }
        catch (Exception e){
            return new ModelAndView("registry", "Error", "Пользователь с таким логином уже существует!");
        }
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(String login, String password){
        System.out.println("Логин");
        return new ModelAndView("login");
    }

}
