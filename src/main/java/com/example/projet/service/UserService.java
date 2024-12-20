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
    private UserRepository userRepository;  // Repository pour accéder aux utilisateurs dans la base de données

    @Autowired
    private UserMapper userMapper;  // Mapper pour convertir entre entités User et UserDTO

    /**
     * Méthode pour récupérer un utilisateur par son id.
     *
     * @param id l'identifiant de l'utilisateur à rechercher.
     * @return UserDTO l'utilisateur trouvé.
     * @throws RuntimeException Si l'utilisateur n'est pas trouvé.
     */
    public UserDTO getUserById(Integer id) {
        // Recherche de l'utilisateur dans la base de données
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        // Retourne le DTO correspondant à l'entité utilisateur
        return userMapper.toDto(user);
    }

    /**
     * Méthode pour récupérer tous les utilisateurs.
     *
     * @return List<UserDTO> liste de tous les utilisateurs sous forme de DTO.
     */
    public List<UserDTO> getAll() {
        // Récupère tous les utilisateurs et les convertit en DTO
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour ajouter un nouvel utilisateur.
     *
     * @param userDTO l'utilisateur à ajouter sous forme de DTO.
     * @return UserDTO le DTO de l'utilisateur ajouté.
     * @throws RuntimeException Si une erreur se produit lors de la sauvegarde.
     */
    public UserDTO addUser(UserDTO userDTO) {
        try {
            // Conversion du DTO en entité User
            User user = userMapper.toEntity(userDTO);
            // Sauvegarde de l'utilisateur dans la base de données
            user = userRepository.save(user);
            // Retourne le DTO de l'utilisateur sauvegardé
            return userMapper.toDto(user);
        } catch (Exception e) {
            // Affiche un message d'erreur en cas d'échec
            System.out.println("Erreur lors de la sauvegarde de l'utilisateur: " + e);
            return null;  // Retourne null en cas d'erreur
        }
    }

    /**
     * Méthode pour mettre à jour les informations d'un utilisateur.
     *
     * @param id l'identifiant de l'utilisateur à mettre à jour.
     * @param userDTO les nouvelles informations de l'utilisateur sous forme de DTO.
     * @return UserDTO le DTO de l'utilisateur mis à jour.
     * @throws RuntimeException si l'utilisateur n'est pas trouvé.
     */
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        // Recherche de l'utilisateur existant dans la base de données
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        // Mise à jour des informations de l'utilisateur uniquement si les champs sont non-nuls
        if (userDTO.getNom() != null) user.setNom(userDTO.getNom());
        if (userDTO.getPrenom() != null) user.setPrenom(userDTO.getPrenom());
        if (userDTO.getUsername() != null) user.setUsername(userDTO.getUsername());
        if (userDTO.getMail() != null) user.setMail(userDTO.getMail());
        if (userDTO.getPassword() != null) user.setPassword(userDTO.getPassword());

        // Sauvegarde des changements dans la base de données
        user = userRepository.save(user);

        // Retourne le DTO de l'utilisateur mis à jour
        return userMapper.toDto(user);
    }

    /**
     * Méthode pour supprimer un utilisateur.
     *
     * @param id l'identifiant de l'utilisateur à supprimer.
     */
    public void deleteUser(Integer id) {
        // Suppression de l'utilisateur en fonction de son ID
        userRepository.deleteById(id);
    }
}
