package com.shelter.coursework.entity;

import com.shelter.coursework.DTO.UserDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String role;
    String login;
    String password;
    @OneToMany(mappedBy = "user")
    List<Animal> animalList;

    public User(){}
    public User(UserDTO userDto){
        if (userDto.getAnimalDTOList() != null){
            animalList = userDto.getAnimalDTOList().stream().map(animal -> new Animal(animal)).collect(Collectors.toList());
        }
        id = userDto.getId();
        role = userDto.getRole();
        login = userDto.getLogin();
        password = userDto.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
