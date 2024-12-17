package com.example.projet.controller;

import com.example.projet.DTO.GameDTO;
import com.example.projet.exception.ApiError;
import com.example.projet.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux jeux.
 * <p>
 * Fournit des endpoints pour récupérer, ajouter, mettre à jour et supprimer des jeux.
 * Gère les erreurs et retourne une réponse appropriée avec des détails sur les erreurs.
 */
@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Récupère la liste de tous les jeux disponibles.
     *
     * @return Une réponse avec la liste des jeux sous forme de GameDTO.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     *
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getGames() {
        try {
            List<GameDTO> gameList = gameService.getGames();
            return new ResponseEntity<>(gameList, HttpStatus.OK);
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
     * Récupère un jeu spécifique en fonction de son identifiant.
     *
     * @param id L'identifiant du jeu.
     * @return Une réponse avec les données du jeu sous forme de GameDTO.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getGamesById(@PathVariable("id") Integer id) {
        try {
            GameDTO gameDTO = gameService.getGameById(id);
            return new ResponseEntity<>(gameDTO, HttpStatus.OK);
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
     * Ajoute un nouveau jeu à la base de données.
     *
     * @param gameDTO Les données du jeu à ajouter sous forme de GameDTO.
     * @return Une réponse avec le jeu créé.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @PostMapping
    public ResponseEntity<?> addGame(@RequestBody GameDTO gameDTO) {
        try {
            return new ResponseEntity<>(gameService.addGame(gameDTO), HttpStatus.OK);
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
     * Supprime un jeu spécifique en fonction de son identifiant.
     *
     * @param id L'identifiant du jeu à supprimer.
     * @return Une réponse sans contenu si la suppression réussit.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable("id") Integer id) {
        try {
            gameService.deleteGame(id);
            return ResponseEntity.noContent().build();
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
     * Met à jour les détails d'un jeu existant.
     *
     * @param id L'identifiant du jeu à mettre à jour.
     * @param gameDTO Les nouvelles données du jeu sous forme de GameDTO.
     * @return Une réponse avec le jeu mis à jour.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGame(@PathVariable("id") Integer id, @RequestBody GameDTO gameDTO) {
        try {
            return new ResponseEntity<>(gameService.updateGame(id, gameDTO), HttpStatus.OK);
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
