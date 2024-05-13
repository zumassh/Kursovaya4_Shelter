package com.shelter.coursework.controller;

import com.shelter.coursework.config.SecurityUtil;
import com.shelter.coursework.entity.Animal;
import com.shelter.coursework.entity.User;
import com.shelter.coursework.service.AnimalService;
import com.shelter.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    AnimalService animalService;
    @Autowired
    UserService userService;

    @GetMapping("/main")
    public ModelAndView getMainPage(){
        List<Animal> animalList = animalService.getAllAnimals();
        ModelAndView modelAndView = new ModelAndView("main", "animals", animalList);
        String login = SecurityUtil.getCurrentUsername();
        User user = userService.getUserByLogin(login);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView bookAnimal(@RequestParam(name = "animalId") Long animalId){
        Animal animal = animalService.getAnimal(animalId);
        String login = SecurityUtil.getCurrentUsername();
        User user = userService.getUserByLogin(login);
        animal.setUser(user);
        animalService.createAnimal(animal);
        return getMainPage();
    }
}
