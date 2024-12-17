package com.example.projet.service;

import com.example.projet.DTO.GameDTO;
import com.example.projet.repository.GameRepository;
import com.example.projet.component.GameMapper;
import com.example.projet.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service de gestion des jeux.
 * <p>
 * Cette classe fournit des méthodes pour gérer les jeux disponibles. Elle inclut des opérations CRUD
 * pour l'entité Game.
 * </p>
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    /**
     * Récupère un jeu spécifique basé sur son id.
     * @param id l'id du jeu
     * @return un DTO du jeu
     */
    public GameDTO getGameById(Integer id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        return gameMapper.toDto(game);
    }

    /**
     * Récupère tous les jeux disponibles.
     * @return une liste de DTO des jeux
     */
    public List<GameDTO> getGames() {
        return gameRepository.findAll().stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Ajoute un nouveau jeu à la base de données.
     * <p>
     * Cette méthode convertit le DTO reçu en entité Game, puis de sauvegarder l'entité dans la base de données.
     * </p>
     * @param gameDTO les informations du jeu à ajouter
     * @return le DTO du jeu ajouté, ou null en cas d'erreur
     */
    public GameDTO addGame(GameDTO gameDTO) {
        try {
            Game game = gameMapper.toEntity(gameDTO);
            game = gameRepository.save(game);
            return gameMapper.toDto(game);
        } catch (Exception e) {
            System.out.println("Conversion DTO erreur");
            return null;
        }
    }

    /**
     * Met à jour un jeu existant avec les nouvelles informations fournies.
     * @param id l'id du jeu à mettre à jour
     * @param gameDTO les nouvelles informations du jeu
     * @return le DTO du jeu mis à jour
     */
    public GameDTO updateGame(Integer id, GameDTO gameDTO) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        if (gameDTO.getNom() != null)  game.setNom(gameDTO.getNom());
        if (gameDTO.getDescription() != null)  game.setDescription(gameDTO.getDescription());
        if (gameDTO.getQuantite() != null)  game.setQuantite(gameDTO.getQuantite());
        if (gameDTO.getPoint_geo() != null) game.setPoint_geo(gameDTO.getPoint_geo());
        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    /**
     * Supprime un jeu existant basé sur son id.
     * @param id l'id du jeu à supprimer
     */
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
}
