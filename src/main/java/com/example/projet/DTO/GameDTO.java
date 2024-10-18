package com.example.projet.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GameDTO {

    private Integer id;
    private String nom;
    private Integer quantite;
    private String description;
    private String point_geo;

}
