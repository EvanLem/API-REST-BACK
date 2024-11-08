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
    private Integer jeuxid;
    private Integer reservation;
}
