package com.shelter.coursework.service;

import com.shelter.coursework.DTO.UserDTO;
import com.shelter.coursework.entity.User;
import com.shelter.coursework.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String createUser(User user) throws Exception{
        if (userRepo.findByLogin(user.getLogin()) != null){
            throw new Exception("Пользователь с таким логином уже существует!");
        }
        userRepo.save(user);
        return "Пользователь добавлен";
    }

    public UserDTO getUser(long id){
        Optional<User> opt = userRepo.findById(id);
        if (opt.isPresent()){
            return new UserDTO(opt.get());
        }
        else{
            return null;
        }
    }

    public List<UserDTO> getAllUser(){
        List<User> users = (List<User>) userRepo.findAll();
        if (users != null){
            return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deleteUser(long id){
        userRepo.deleteById(id);
        return "Пользователь с id " + id + " удален.";
    }

    public User getUserByLogin(String login){
        return userRepo.findByLogin(login);
    }
}
