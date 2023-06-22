package com.mixquest.mixquestapi.controller;

import com.mixquest.mixquestapi.model.User;
import com.mixquest.mixquestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUser() {
        List<User> result = userRepository.findAll();
        System.out.println(result);
        return result;
    }
}
