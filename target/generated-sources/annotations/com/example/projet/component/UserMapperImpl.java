package com.example.projet.component;

import com.example.projet.DTO.UserDTO;
import com.example.projet.DTO.UserDTO.UserDTOBuilder;
import com.example.projet.entity.User;
import com.example.projet.entity.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T14:20:21+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.nom( user.getNom() );
        userDTO.prenom( user.getPrenom() );
        userDTO.mail( user.getMail() );
        userDTO.password( user.getPassword() );
        userDTO.username( user.getUsername() );

        return userDTO.build();
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( userDTO.getId() );
        user.nom( userDTO.getNom() );
        user.prenom( userDTO.getPrenom() );
        user.mail( userDTO.getMail() );
        user.password( userDTO.getPassword() );
        user.username( userDTO.getUsername() );

        return user.build();
    }
}
