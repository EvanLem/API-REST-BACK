package com.example.projet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Clé composite représentant l'identifiant unique pour une réservation,
 * composé de l'ID de l'utilisateur et de l'ID du jeu.
 * <p>
 * Cette classe est utilisée pour identifier de manière unique une réservation dans la base de données
 * en combinant l'ID de l'utilisateur (`userId`) et l'ID du jeu (`gameId`).
 * Elle est utilisée comme clé primaire composite dans la classe `Booking`.
 */
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class BookingKey implements Serializable {

    /**
     * L'ID de l'utilisateur effectuant la réservation.
     * <p>
     * Correspond à la colonne `utilisateur_id` dans la base de données.
     */
    @Column(name="utilisateur_id")
    Integer userId;

    /**
     * L'ID du jeu qui est réservé.
     * <p>
     * Correspond à la colonne `jeux_id` dans la base de données.
     */
    @Column(name="jeux_id")
    Integer gameId;

    /**
     * Constructeur pour créer une clé composite avec un utilisateur et un jeu spécifiques.
     *
     * @param userId L'ID de l'utilisateur.
     * @param gameId L'ID du jeu.
     */
    public BookingKey(Integer userId, Integer gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }
}
