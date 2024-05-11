package com.shelter.coursework.controller;

import com.shelter.coursework.DTO.AnimalDTO;
import com.shelter.coursework.entity.Animal;
import com.shelter.coursework.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    AnimalService service;
    @GetMapping
    public List<Animal> getAnimal(){
        return service.getAllAnimals();
    }
    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable long id){
        return service.getAnimal(id);
    }
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable long id){
        return service.deleteAnimal(id);
    }
}
