package com.example.projet.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
@Table(name="utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    @NonNull
    @JsonProperty("nom")
    private String nom;

    @NonNull
    @JsonProperty("prenom")
    private String prenom;

    @NonNull
    @JsonProperty("mail")
    private String mail;

    @NonNull
    @JsonProperty("password")
    private String password;

    @NonNull
    @JsonProperty("username")
    private String username;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("game")
    Set<Booking> booking;
}
