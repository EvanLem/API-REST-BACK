package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.JeuxDTO;
import com.polytech.polytech.entity.Jeux;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JeuxMapper {
    JeuxDTO toDto(Jeux jeux);
    Jeux toEntity(JeuxDTO jeuxDTO);
}