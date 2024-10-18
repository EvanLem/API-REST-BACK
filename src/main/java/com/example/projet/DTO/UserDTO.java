package com.example.projet.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String username;

}
