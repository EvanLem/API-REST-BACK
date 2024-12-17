package com.example.projet.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Représente un jeu dans le système, avec des informations telles que le nom, la quantité disponible, la description et l'emplacement.
 * <p>
 * Cette entité est liée à la table `jeux` dans la base de données et contient des informations sur les jeux
 * que les utilisateurs peuvent réserver.
 * Elle contient également une collection de réservations (`Booking`) associées à ce jeu.
 */
@Entity
@Table(name="jeux")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class Game {

    /**
     * L'ID unique du jeu.
     * <p>
     * Cet identifiant est généré automatiquement par la base de données et correspond à la colonne `id` dans la table `jeux`.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    /**
     * Le nom du jeu.
     * <p>
     * Correspond à la colonne `nom` dans la base de données.
     * Ce champ est obligatoire pour un jeu.
     */
    @NonNull
    @JsonProperty("nom")
    private String nom;

    /**
     * La quantité de ce jeu disponible.
     * <p>
     * Correspond à la colonne `quantite` dans la base de données.
     * Ce champ est obligatoire pour un jeu.
     */
    @NonNull
    @JsonProperty("quantite")
    private Integer quantite;

    /**
     * La description du jeu.
     * <p>
     * Correspond à la colonne `description` dans la base de données.
     * Ce champ est obligatoire pour un jeu.
     */
    @NonNull
    @JsonProperty("description")
    private String description;

    /**
     * L'emplacement géographique associé à ce jeu.
     * <p>
     * Correspond à la colonne `point_geo` dans la base de données.
     * Ce champ est obligatoire pour un jeu.
     */
    @NonNull
    @JsonProperty("point_geo")
    private String point_geo;

    /**
     * Les réservations associées à ce jeu.
     * <p>
     * Cette relation est définie par la clé étrangère dans la table `reservation` qui fait référence à cet entité `Game`.
     * Le mappage est effectué à travers l'attribut `game` de la classe `Booking`.
     * L'annotation `@JsonIgnoreProperties` est utilisée pour ignorer les propriétés non pertinentes dans la réponse JSON.
     */
    @OneToMany(mappedBy = "game")
    @JsonIgnoreProperties(ignoreUnknown = true)
    Set<Booking> booking;
}
