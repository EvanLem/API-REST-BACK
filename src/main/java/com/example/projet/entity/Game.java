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
@Table(name="jeux")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    private String nom;

    @NonNull
    private Integer quantite;

    private String description;

    @NonNull
    private String point_geo;

    @OneToMany(mappedBy = "game")
    Set<Booking> booking;
}
