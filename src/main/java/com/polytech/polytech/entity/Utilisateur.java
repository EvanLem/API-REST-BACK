package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="utilisateur")
@Getter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String mail;

    @NonNull
    private String password;

    @NonNull
    private String username;
}