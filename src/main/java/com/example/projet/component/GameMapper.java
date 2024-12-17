package com.example.projet.component;

import com.example.projet.DTO.GameDTO;
import com.example.projet.entity.Game;
import org.mapstruct.Mapper;

/**
 * Mappage pour convertir les entités Game et les objets DTO GameDTO
 */
@Mapper(componentModel = "spring")
public interface GameMapper {

    /**
     * Convertit une entité Game en un objet GameDTO.
     *
     * @param game L'entité Game à convertir.
     * @return Un objet GameDTO avec les données de l'entité.
     */
    GameDTO toDto(Game game);

    /**
     * Convertit un objet GameDTO en une entité Game.
     *
     * @param gameDTO L'objet GameDTO à convertir.
     * @return Une entité Game avec les données du DTO.
     */
    Game toEntity(GameDTO gameDTO);
}
