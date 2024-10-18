package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservation")
@IdClass(ReservationId.class)
public class Reservation {

    @Id
    @Column(name = "utilisateur_id")
    private Integer utilisateurId;

    @Id
    @Column(name = "jeux_id")
    private Integer jeuxId;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "jeux_id", insertable = false, updatable = false)
    private Jeux jeux;

    private int reservation;
}