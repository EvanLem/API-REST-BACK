package com.example.projet.component;

import com.example.projet.DTO.GameDTO;
import com.example.projet.DTO.GameDTO.GameDTOBuilder;
import com.example.projet.entity.Game;
import com.example.projet.entity.Game.GameBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T14:20:21+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class GameMapperImpl implements GameMapper {

    @Override
    public GameDTO toDto(Game game) {
        if ( game == null ) {
            return null;
        }

        GameDTOBuilder gameDTO = GameDTO.builder();

        gameDTO.id( game.getId() );
        gameDTO.nom( game.getNom() );
        gameDTO.quantite( game.getQuantite() );
        gameDTO.description( game.getDescription() );
        gameDTO.point_geo( game.getPoint_geo() );

        return gameDTO.build();
    }

    @Override
    public Game toEntity(GameDTO gameDTO) {
        if ( gameDTO == null ) {
            return null;
        }

        GameBuilder game = Game.builder();

        game.id( gameDTO.getId() );
        game.nom( gameDTO.getNom() );
        game.quantite( gameDTO.getQuantite() );
        game.description( gameDTO.getDescription() );
        game.point_geo( gameDTO.getPoint_geo() );

        return game.build();
    }
}
