package com.example.projet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name="utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @OneToMany(mappedBy = "user")
    Set<Booking> booking;
}
