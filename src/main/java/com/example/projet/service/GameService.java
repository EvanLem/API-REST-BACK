package com.example.projet.service;

import com.example.projet.GameRepository;
import com.example.projet.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    // Méthode pour récupérer tous les utilisateurs
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // Méthode pour ajouter un utilisateur
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }
}
