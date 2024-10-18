package com.polytech.polytech.dto;

import lombok.* ;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JeuxDTO {
    private Integer id;
    private String nom;
    private Integer quantite;
    private String description;
    private String point_geo;
}
