package com.example.projet.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Représente une réservation d'un jeu par un utilisateur.
 * <p>
 * La classe Booking est une entité qui correspond à une réservation dans la base de données.
 */
@Entity
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="reservation")
public class Booking {

    /**
     * Identifiant composite pour la réservation, composé des identifiants de l'utilisateur et du jeu.
     */
    @EmbeddedId
    BookingKey id;

    /**
     * L'utilisateur qui a effectué la réservation.
     * Il est lié à la clé composite via la colonne "utilisateur_id".
     */
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="utilisateur_id")
    User user;

    /**
     * Le jeu qui a été réservé.
     * Il est lié à la clé composite via la colonne "jeux_id".
     */
    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name="jeux_id")
    Game game;

    /**
     * Le nombre de réservations effectuées pour ce jeu par l'utilisateur.
     */
    Integer reservation;
}
