package com.shelter.coursework.service;
import com.shelter.coursework.DTO.AnimalDTO;
import com.shelter.coursework.entity.Animal;
import com.shelter.coursework.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AnimalService {
    @Autowired
    AnimalRepo animalRepo;

    public String createAnimal(Animal animal){
        animalRepo.save(animal);
        return animal.getType() + " добавлена.";
    }

    public Animal getAnimal(long id){
       Optional<Animal> animal = animalRepo.findById(id);
       if (animal.isPresent())
           return animal.get();
       return null;
    }

    public List<Animal> getAllAnimals(){
        List<Animal> animals = (List<Animal>) animalRepo.findAll();
        return animals;
    }

    public String deleteAnimal(long id){
        animalRepo.deleteById(id);
        return "Животное с id " + id + " удалено.";
    }

}
