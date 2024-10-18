package com.example.projet.component;

import com.example.projet.DTO.GameDTO;
import com.example.projet.entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO toDTO(Game user);
    Game toEntity(GameDTO userDTO);
}
