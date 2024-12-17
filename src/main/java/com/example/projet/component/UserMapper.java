package com.example.projet.component;

import com.example.projet.DTO.UserDTO;
import com.example.projet.entity.User;
import org.mapstruct.Mapper;

/**
 * Mappage pour convertir les entités User et les objets DTO UserDTO
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Convertit une entité User en un objet UserDTO.
     *
     * @param user L'entité User à convertir.
     * @return Un objet UserDTO avec les données de l'entité User.
     */
    UserDTO toDto(User user);

    /**
     * Convertit un objet UserDTO en une entité User.
     *
     * @param userDTO L'objet UserDTO à convertir.
     * @return Une entité User avec les données du DTO UserDTO.
     */
    User toEntity(UserDTO userDTO);
}
