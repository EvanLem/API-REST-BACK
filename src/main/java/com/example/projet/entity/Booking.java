package com.example.projet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="reservation")
public class Booking {

    @EmbeddedId
    BookingKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="utilisateur_id")
    User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name="jeux_id")
    Game game;

    Integer reservation;
}