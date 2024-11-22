package com.example.projet.controller;

import com.example.projet.DTO.GameDTO;
import com.example.projet.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint pour récupérer tous les jeux
    @GetMapping(produces="application/json")
    public ResponseEntity<List<GameDTO>> getGames() {
        List<GameDTO> gameList = gameService.getGames();
        return new ResponseEntity<>(gameList, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<GameDTO> getGamesById(@PathVariable("id") Integer id) {
        GameDTO gameDTO = gameService.getGameById(id);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    // Endpoint pour ajouter un jeu
    @PostMapping()
    public ResponseEntity<GameDTO> addGame(@RequestBody GameDTO gameDTO) {
        return new ResponseEntity<>(gameService.addGame(gameDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") Integer id) {
        gameService.deleteGame(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable("id") Integer id, @RequestBody GameDTO gameDTO) {
        return new ResponseEntity<>(gameService.updateGame(id, gameDTO), HttpStatus.OK);
    }

}
