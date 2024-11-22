package com.example.projet.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    @NonNull
    @JsonProperty("nom")
    private String nom;

    @NonNull
    @JsonProperty("quantite")
    private Integer quantite;

    @NonNull
    @JsonProperty("description")
    private String description;

    @NonNull
    @JsonProperty("point_geo")
    private String point_geo;

    //@JsonIgnoreProperties("game")
    @OneToMany(mappedBy = "game")
    @JsonIgnoreProperties(ignoreUnknown = true)
    Set<Booking> booking;
}
