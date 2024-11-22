package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.JeuxDTO;
import com.polytech.polytech.dto.JeuxDTO.JeuxDTOBuilder;
import com.polytech.polytech.entity.Jeux;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-08T15:16:23+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class JeuxMapperImpl implements JeuxMapper {

    @Override
    public Jeux toEntity(JeuxDTO jeuxDTO) {
        if ( jeuxDTO == null ) {
            return null;
        }

        Jeux jeux = new Jeux();

        jeux.setId( jeuxDTO.getId() );
        jeux.setNom( jeuxDTO.getNom() );
        jeux.setQuantite( jeuxDTO.getQuantite() );
        jeux.setDescription( jeuxDTO.getDescription() );

        return jeux;
    }

    @Override
    public JeuxDTO toDto(Jeux jeux) {
        if ( jeux == null ) {
            return null;
        }

        JeuxDTOBuilder jeuxDTO = JeuxDTO.builder();

        jeuxDTO.id( jeux.getId() );
        jeuxDTO.nom( jeux.getNom() );
        jeuxDTO.quantite( jeux.getQuantite() );
        jeuxDTO.description( jeux.getDescription() );

        return jeuxDTO.build();
    }
}
