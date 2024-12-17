package com.example.projet.DTO;

import lombok.*;

/**
 * DTO représentant une réservation de jeu.
 * <p>
 * Cette classe sert de transfert de données pour les réservations.
 * Elle contient les informations liées à la réservation d'un utilisateur pour un jeu.
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookingDTO {

    /**
     * L'identifiant de l'utilisateur qui effectue la réservation.
     * La clé étrangère référant à l'utilisateur dans la base de données.
     */
    private Integer utilisateurId;

    /**
     * L'identifiant du jeu réservé.
     * La clé étrangère référant au jeu dans la base de données.
     */
    private Integer jeuxId;

    /**
     * Le nombre de place réservé.
     */
    private Integer reservation;
}
