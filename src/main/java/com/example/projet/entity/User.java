package com.example.projet.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Représente un utilisateur dans le système, avec des informations telles que le nom, le prénom, l'email, le mot de passe et le nom d'utilisateur.
 * <p>
 * Cette entité est liée à la table `utilisateur` dans la base de données et contient des informations sur les utilisateurs
 * qui peuvent effectuer des réservations de jeux.
 * Elle contient également une collection de réservations (`Booking`) associées à cet utilisateur.
 */
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
@Table(name="utilisateur")
public class User {

    /**
     * L'ID unique de l'utilisateur.
     * <p>
     * Cet identifiant est généré automatiquement par la base de données et correspond à la colonne `id` dans la table `utilisateur`.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    /**
     * Le nom de l'utilisateur.
     * <p>
     * Correspond à la colonne `nom` dans la base de données.
     * Ce champ est obligatoire pour chaque utilisateur.
     */
    @NonNull
    @JsonProperty("nom")
    private String nom;

    /**
     * Le prénom de l'utilisateur.
     * <p>
     * Correspond à la colonne `prenom` dans la base de données.
     * Ce champ est obligatoire pour chaque utilisateur.
     */
    @NonNull
    @JsonProperty("prenom")
    private String prenom;

    /**
     * L'email de l'utilisateur.
     * <p>
     * Correspond à la colonne `mail` dans la base de données.
     * Ce champ est obligatoire pour chaque utilisateur.
     */
    @NonNull
    @JsonProperty("mail")
    private String mail;

    /**
     * Le mot de passe de l'utilisateur.
     * <p>
     * Correspond à la colonne `password` dans la base de données.
     * Ce champ est obligatoire pour chaque utilisateur.
     */
    @NonNull
    @JsonProperty("password")
    private String password;

    /**
     * Le nom d'utilisateur de l'utilisateur.
     * <p>
     * Correspond à la colonne `username` dans la base de données.
     * Ce champ est obligatoire pour chaque utilisateur.
     */
    @NonNull
    @JsonProperty("username")
    private String username;

    /**
     * Les réservations associées à cet utilisateur.
     * <p>
     * Cette relation est définie par la clé étrangère dans la table `reservation` qui fait référence à cette entité `User`.
     * Le mappage est effectué à travers l'attribut `user` de la classe `Booking`.
     * L'annotation `@JsonIgnoreProperties` est utilisée pour ignorer les propriétés non pertinentes dans la réponse JSON.
     */
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("game")
    Set<Booking> booking;
}
