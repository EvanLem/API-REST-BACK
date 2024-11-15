package com.example.projet.service;

import com.example.projet.DTO.UserDTO;
import com.example.projet.repository.UserRepository;
import com.example.projet.component.UserMapper;
import com.example.projet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        return userMapper.toDto(user);
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // Méthode pour ajouter un utilisateur
    public UserDTO addGame(UserDTO userDTO) {
        try {
            System.out.println(userDTO);
            User user = userMapper.toEntity(userDTO);
            System.out.println(user.toString());
            user = userRepository.save(user);
            return userMapper.toDto(user);
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde de l'utilisateur: " + e);
            return null;
        }
    }

    public UserDTO updateGame(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        if (userDTO.getNom() != null)  user.setNom(userDTO.getNom());
        if (userDTO.getPrenom() != null)  user.setPrenom(userDTO.getPrenom());
        if (userDTO.getUsername() != null)  user.setUsername(userDTO.getUsername());
        if (userDTO.getMail() != null) user.setMail(userDTO.getMail());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteGame(Integer id) {
        userRepository.deleteById(id);
    }

}
