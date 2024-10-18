package com.example.projet.controller;

import com.example.projet.entity.Game;
import com.example.projet.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint pour récupérer tous les jeux
    @GetMapping()
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    // Endpoint pour ajouter un jeu
    @PostMapping()
    public Game addGame(@RequestBody Game game) {
        return gameService.addGame(game);
    }
}
