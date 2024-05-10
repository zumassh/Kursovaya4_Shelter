package com.shelter.coursework.DTO;

import com.shelter.coursework.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    Long id;
    String role;
    String login;
    String password;
    List<AnimalDTO> animalDTOList;

    public UserDTO(){}
    public UserDTO(User user){
        this.id = user.getId();
        this.role = user.getRole();
        this.login = user.getLogin();
        this.password = user.getPassword();
        if (user.getAnimalList() != null){
            this.animalDTOList = user.getAnimalList().stream().map(AnimalDTO::new).collect(Collectors.toList());
        }
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

    public List<AnimalDTO> getAnimalDTOList() {
        return animalDTOList;
    }

    public void setAnimalDTOList(List<AnimalDTO> animalDTOList) {
        this.animalDTOList = animalDTOList;
    }
}
