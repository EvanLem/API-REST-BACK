package com.example.projet.DTO;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookingDTO {
    private Integer utilisateurId;
    private Integer jeuxId;
    private Integer reservation;
}