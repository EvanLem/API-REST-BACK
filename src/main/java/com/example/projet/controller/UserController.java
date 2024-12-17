package com.example.projet.controller;

import com.example.projet.DTO.UserDTO;
import com.example.projet.component.UserMapper;
import com.example.projet.exception.ApiError;
import com.example.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux utilisateurs.
 * <p>
 * Fournit des endpoints pour récupérer, ajouter, mettre à jour les utilisateurs.
 * Gère les erreurs et retourne une réponse appropriée avec des détails sur les erreurs.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return Une réponse contenant la liste des utilisateurs sous forme de UserDTO.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getUsers() {
        try {
            List<UserDTO> users = userService.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Récupère un utilisateur spécifique en fonction de son identifiant.
     *
     * @param id L'identifiant de l'utilisateur.
     * @return Une réponse contenant les données de l'utilisateur sous forme de UserDTO.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Ajoute un nouvel utilisateur à la base de données.
     *
     * @param userDTO Les données de l'utilisateur à ajouter sous forme de UserDTO.
     * @return Une réponse contenant l'utilisateur créé.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        try {
            System.out.println(userDTO.toString());
            return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Met à jour les détails d'un utilisateur existant.
     *
     * @param id L'identifiant de l'utilisateur à mettre à jour.
     * @param userDTO Les nouveaux données de l'utilisateur sous forme de UserDTO.
     * @return Une réponse contenant l'utilisateur mis à jour.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        try {
            return new ResponseEntity<>(userService.updateUser(id, userDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
