package com.example.projet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
class BookingKey implements Serializable {

    @Column(name="utilisateur_id")
    Long userId;

    @Column(name="jeux_id")
    Long gameId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}