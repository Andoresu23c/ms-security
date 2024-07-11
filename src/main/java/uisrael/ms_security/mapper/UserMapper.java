package uisrael.ms_security.mapper;

import org.springframework.stereotype.Component;
import uisrael.ms_security.dto.UserDTO;
import uisrael.ms_security.model.User;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setDocumentType(user.getDocumentType());
        userDTO.setDocument(user.getDocument());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setStatus(user.getStatus());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setDocumentType(userDTO.getDocumentType());
        user.setDocument(userDTO.getDocument());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
}
