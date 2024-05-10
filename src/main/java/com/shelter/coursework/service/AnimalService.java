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

    public AnimalDTO getAnimal(long id){
        Optional<Animal> opt = animalRepo.findById(id);
        if (opt.isPresent()){
            return new AnimalDTO(opt.get());
        }
        else{
            return null;
        }
    }

    public List<AnimalDTO> getAllAnimals(){
        List<Animal> animals = (List<Animal>) animalRepo.findAll();
        if (animals != null){
            return animals.stream().map(AnimalDTO::new).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deleteAnimal(long id){
        animalRepo.deleteById(id);
        return "Животное с id " + id + " удалено.";
    }
}
