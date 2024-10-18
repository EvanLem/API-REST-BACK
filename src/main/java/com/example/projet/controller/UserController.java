package com.example.projet.controller;

import com.example.projet.DTO.UserDTO;
import com.example.projet.component.UserMapper;
import com.example.projet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserMapper mapper;

    @GetMapping()
    public List<UserDTO> getUsers() {
        System.out.println("TEST user");
        return userService.getAll()
                .stream()
                .map(mapper::toDTO)
                .collect(toList());
    }

    @GetMapping(value="/{id}")
    public boolean getUserById() {
        System.out.println("Test 1 user.");
        return true;
    }

}
