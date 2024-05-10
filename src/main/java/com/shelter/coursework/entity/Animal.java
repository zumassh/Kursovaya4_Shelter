package com.shelter.coursework.entity;

import com.shelter.coursework.DTO.AnimalDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
    String type;
    String name;
    int age;
    char sex;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    Image photo;
    String description;
    public Animal(){}
    public Animal(AnimalDTO animalDTO){
        this.id = animalDTO.getId();
        this.name = animalDTO.getName();
        this.type = animalDTO.getType();
        //this.photo = animalDTO.getPhoto();
        this.description = animalDTO.getDescription();
        this.age = animalDTO.getAge();
        this.sex = animalDTO.getSex();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
