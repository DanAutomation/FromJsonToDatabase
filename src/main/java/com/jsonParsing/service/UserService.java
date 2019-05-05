package com.jsonParsing.service;

import java.util.List;

import com.jsonParsing.domain.User;
import com.jsonParsing.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Iterable<User> save(List<User> users){
        return userRepository.save(users);
    }
}
