package com.example.projet.component;

import com.example.projet.DTO.BookingDTO;
import com.example.projet.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(source = "user.id", target = "utilisateurId")
    @Mapping(source = "game.id", target = "jeuxId")
    BookingDTO toDto(Booking game);

    @Mapping(target = "id.userId", source = "utilisateurId")
    @Mapping(target = "id.gameId", source = "jeuxId")
    @Mapping(target = "user", ignore = true) // Ignore et injecter l'entité réelle plus tard
    @Mapping(target = "game", ignore = true) // Ignore et injecter l'entité réelle plus tard
    Booking toEntity(BookingDTO gameDTO);
}
