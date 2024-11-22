package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO toDto(Utilisateur utilisateur);
}