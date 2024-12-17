package com.example.projet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * DTO représentant un jeu.
 * <p>
 * Cette classe est utilisée pour transférer les informations relatives à un jeu
 * Elle contient les informations sur un jeu.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class GameDTO {

    /**
     * L'identifiant unique du jeu.
     * Ce champ est utilisé pour référencer un jeu dans la base de données.
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * Le nom du jeu.
     */
    @JsonProperty("nom")
    private String nom;

    /**
     * La quantité disponible du jeu.
     */
    @JsonProperty("quantite")
    private Integer quantite;

    /**
     * Une description du jeu.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Les coordonnées géographiques associées au jeu.
    */
    @JsonProperty("point_geo")
    private String point_geo;
}
