package com.cursonelio.course.services;

import com.cursonelio.course.entities.User;
import com.cursonelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//temos que falar que é um serviço injetável
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj =  userRepository.findById(id);
        return obj.get();
    }
}