package com.example.projet.service;

import com.example.projet.UserRepository;
import com.example.projet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
