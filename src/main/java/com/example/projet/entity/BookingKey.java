package com.example.projet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookingKey implements Serializable {

    // Getters et setters
    @Column(name="utilisateur_id")
    Integer userId;

    @Column(name="jeux_id")
    Integer gameId;
}