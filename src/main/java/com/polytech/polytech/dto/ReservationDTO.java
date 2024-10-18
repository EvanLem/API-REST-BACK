package com.polytech.polytech.dto;

import lombok.* ;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {
    private Integer utilisateur_id;
    private Integer jeux_id;
    private Integer reservation;
}
