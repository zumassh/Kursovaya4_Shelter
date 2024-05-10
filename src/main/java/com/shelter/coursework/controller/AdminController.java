package com.shelter.coursework.controller;

import com.shelter.coursework.DTO.AnimalDTO;
import com.shelter.coursework.config.SecurityUtil;
import com.shelter.coursework.entity.Animal;
import com.shelter.coursework.entity.Image;
import com.shelter.coursework.entity.User;
import com.shelter.coursework.service.AnimalService;
import com.shelter.coursework.service.ImageService;
import com.shelter.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    AnimalService animalService;

    @Autowired
    ImageService imageService;
    @GetMapping("/addAnimal")
    public ModelAndView getAddAnimalPage(){
        String login = SecurityUtil.getCurrentUsername();
        User currentUser = userService.getUserByLogin(login);
        System.out.println(currentUser.getRole());
        if (!currentUser.getRole().equals("adm")){
            return new ModelAndView("main");
        }
        return new ModelAndView("addAnimal");
    }

    @PostMapping("/addAnimal")
    public ModelAndView addAnimal(@ModelAttribute AnimalDTO animalDTO, @RequestParam("photo") MultipartFile photoFile){
        System.out.println(animalDTO);
        Image image = new Image();
        image.setName(animalDTO.getName() + " " + animalDTO.getType());
        try {
            byte[] bytes = photoFile.getBytes();
            System.out.println(bytes.length);
            image.setData(photoFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            // Обработка ошибки чтения данных изображения
        }
        imageService.saveImage(image);

        Animal animal = new Animal();
        animal.setName(animalDTO.getName());
        animal.setType(animalDTO.getType());
        animal.setAge(animalDTO.getAge());
        animal.setSex(animalDTO.getSex());
        animal.setDescription(animalDTO.getDescription());
        animal.setPhoto(image);

        animalService.createAnimal(animal);
        return new ModelAndView("addAnimal", "success", "Животное успешно добавлено.");
    }
}
