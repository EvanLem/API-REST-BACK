package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.JeuxDTO;
import com.polytech.polytech.entity.Jeux;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JeuxMapper {
    JeuxMapper INSTANCE = Mappers.getMapper(JeuxMapper.class);

    Jeux toEntity(JeuxDTO jeuxDTO);

    JeuxDTO toDto(Jeux jeux);
}