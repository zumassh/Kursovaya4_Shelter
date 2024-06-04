package com.shelter.coursework.repository;

import com.shelter.coursework.entity.Animal;
import com.shelter.coursework.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends CrudRepository<Animal, Long> {
    Iterable<Animal> findAnimalsByUser(User user);
}
