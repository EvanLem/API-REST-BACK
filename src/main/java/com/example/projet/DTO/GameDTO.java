package com.example.projet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class GameDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("quantite")
    private Integer quantite;
    @JsonProperty("description")
    private String description;
    @JsonProperty("point_geo")
    private String point_geo;
}
