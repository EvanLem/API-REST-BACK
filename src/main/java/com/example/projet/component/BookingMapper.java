package com.example.projet.component;

import com.example.projet.DTO.BookingDTO;
import com.example.projet.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mappage pour convertir les entités Booking et les objets DTO BookingDTO
 */
@Mapper(componentModel = "spring")
public interface BookingMapper {

    /**
     * Convertit une entité Booking en un objet BookingDTO.
     *
     * @param game L'entité Booking à convertir.
     * @return Un objet BookingDTO avec les données de l'entité.
     */
    @Mapping(source = "user.id", target = "utilisateurId") // Mappe l'ID de l'utilisateur
    @Mapping(source = "game.id", target = "jeuxId")       // Mappe l'ID du jeu
    BookingDTO toDto(Booking game);

    /**
     * Convertit un objet BookingDTO en une entité Booking.
     *
     * @param gameDTO L'objet BookingDTO à convertir.
     * @return Une entité Booking avec les données du DTO.
     */
    @Mapping(target = "id.userId", source = "utilisateurId") // Mappe l'ID utilisateur dans la clé composite
    @Mapping(target = "id.gameId", source = "jeuxId")       // Mappe l'ID jeu dans la clé composite
    @Mapping(target = "user", ignore = true)               // Ignore l'association avec utilisateur
    @Mapping(target = "game", ignore = true)               // Ignore l'association avec jeu
    Booking toEntity(BookingDTO gameDTO);
}
