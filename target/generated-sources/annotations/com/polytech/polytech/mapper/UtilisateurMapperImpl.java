package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.UtilisateurDTO;
import com.polytech.polytech.dto.UtilisateurDTO.UtilisateurDTOBuilder;
import com.polytech.polytech.entity.Utilisateur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-08T15:16:23+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {
        if ( utilisateurDTO == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId( utilisateurDTO.getId() );
        utilisateur.setNom( utilisateurDTO.getNom() );
        utilisateur.setPrenom( utilisateurDTO.getPrenom() );
        utilisateur.setMail( utilisateurDTO.getMail() );
        utilisateur.setPassword( utilisateurDTO.getPassword() );
        utilisateur.setUsername( utilisateurDTO.getUsername() );

        return utilisateur;
    }

    @Override
    public UtilisateurDTO toDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDTOBuilder utilisateurDTO = UtilisateurDTO.builder();

        utilisateurDTO.id( utilisateur.getId() );
        utilisateurDTO.nom( utilisateur.getNom() );
        utilisateurDTO.prenom( utilisateur.getPrenom() );
        utilisateurDTO.mail( utilisateur.getMail() );
        utilisateurDTO.password( utilisateur.getPassword() );
        utilisateurDTO.username( utilisateur.getUsername() );

        return utilisateurDTO.build();
    }
}
