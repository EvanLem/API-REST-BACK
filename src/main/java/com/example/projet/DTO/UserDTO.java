package com.example.projet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * DTO représentant un utilisateur.
 * <p>
 * Cette classe est utilisée pour transférer les informations d'un utilisateur
 * Elle contient les informations essentielles sur un utilisateur.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class UserDTO {

    /**
     * L'identifiant unique de l'utilisateur.
     * Ce champ est utilisé pour référencer un utilisateur dans la base de données.
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * Le nom de l'utilisateur.
     */
    @JsonProperty("nom")
    private String nom;

    /**
     * Le prénom de l'utilisateur.
     */
    @JsonProperty("prenom")
    private String prenom;

    /**
     * L'adresse email de l'utilisateur.
     */
    @JsonProperty("mail")
    private String mail;

    /**
     * Le mot de passe de l'utilisateur.
     */
    @JsonProperty("password")
    private String password;

    /**
     * Le nom d'utilisateur de l'utilisateur.
     */
    @JsonProperty("username")
    private String username;
}
