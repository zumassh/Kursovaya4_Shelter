package com.shelter.coursework.controller;

import com.shelter.coursework.DTO.UserDTO;
import com.shelter.coursework.entity.User;
import com.shelter.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;


    @GetMapping
    public List<UserDTO> getUser(){
        return service.getAllUser();
    }
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id){
        return service.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }
}
