package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jeux")
@Getter
public class Jeux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nom;

    @NonNull
    private Integer quantite;

    @NonNull
    private String description;

    @NonNull
    private String pointGeo;
}