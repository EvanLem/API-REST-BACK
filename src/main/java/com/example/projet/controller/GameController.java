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

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint pour récupérer tous les jeux
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

    // Endpoint pour ajouter un jeu
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
