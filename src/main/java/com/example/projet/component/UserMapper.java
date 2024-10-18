package com.example.projet.component;

import com.example.projet.DTO.UserDTO;
import com.example.projet.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}

/*
@Component
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserMapper {
    public UserDTO toDto(User user) {
        Integer id = user.getId();
        String name = user.getNom();
        String prenom = user.getPrenom();
        String mail = user.getMail();
        String username = user.getUsername();

        return new UserDTO(id, name, prenom, mail, username);
    }

    /*public User toUser(UserCreationDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
    }
}
*/