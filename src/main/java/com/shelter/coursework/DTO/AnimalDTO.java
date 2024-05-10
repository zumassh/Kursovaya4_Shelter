package com.shelter.coursework.DTO;

import com.shelter.coursework.entity.Animal;
import com.shelter.coursework.entity.User;

public class AnimalDTO {
    Long id;
    String name;
    String type;
    int age;

    char sex;
    String description;
    UserDTO user;
    public AnimalDTO(){}
    public AnimalDTO(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.type = animal.getType();
        this.age = animal.getAge();
        this.sex = animal.getSex();
        this.description = animal.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "AnimalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
