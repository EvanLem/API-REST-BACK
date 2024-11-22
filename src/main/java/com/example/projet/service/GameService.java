package com.example.projet.service;

import com.example.projet.DTO.GameDTO;
import com.example.projet.repository.GameRepository;
import com.example.projet.component.GameMapper;
import com.example.projet.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    public GameDTO getGameById(Integer id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        return gameMapper.toDto(game);
    }

    public List<GameDTO> getGames() {
        return gameRepository.findAll().stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }

    // Méthode pour ajouter un utilisateur
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

    public GameDTO updateGame(Integer id, GameDTO gameDTO) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        if (gameDTO.getNom() != null)  game.setNom(gameDTO.getNom());
        if (gameDTO.getDescription() != null)  game.setDescription(gameDTO.getDescription());
        if (gameDTO.getQuantite() != null)  game.setQuantite(gameDTO.getQuantite());
        if (gameDTO.getPoint_geo() != null) game.setPoint_geo(gameDTO.getPoint_geo());
        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

}
