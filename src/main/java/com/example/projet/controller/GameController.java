package com.example.projet.controller;

import com.example.projet.DTO.GameDTO;
import com.example.projet.exception.ApiError;
import com.example.projet.service.GameService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint pour récupérer tous les jeux
    @GetMapping(produces="application/json")
    public ResponseEntity<?> getGames() {
        try {
            return new ResponseEntity<>(gameService.getGames(), HttpStatus.OK);
        }catch (RuntimeException e) {
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
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getGamesById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.OK);
        }catch (RuntimeException e) {
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
    @PostMapping()
    public ResponseEntity<?> addGame(@RequestBody GameDTO gameDTO) {
        try {
            return new ResponseEntity<>(gameService.addGame(gameDTO), HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (EntityExistsException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.CONFLICT.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
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
    public ResponseEntity<ApiError> deleteGame(@PathVariable("id") Integer id) {
        try {
            gameService.deleteGame(id);
        }catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (EntityExistsException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.CONFLICT.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGame(@PathVariable("id") Integer id, @RequestBody GameDTO gameDTO) {
        try {
            return new ResponseEntity<>(gameService.updateGame(id, gameDTO), HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (EntityExistsException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.CONFLICT.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
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
