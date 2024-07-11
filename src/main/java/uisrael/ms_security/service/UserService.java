package uisrael.ms_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.dto.UserDTO;
import uisrael.ms_security.mapper.UserMapper;
import uisrael.ms_security.model.User;
import uisrael.ms_security.repository.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public Response<List<UserDTO>> findAll() {
        List<UserDTO> users = userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
        return new Response<>(UUID.randomUUID().toString(), "Object List", users, "User records retrieved successfully.");
    }

    public Response<UserDTO> findById(Integer id) {
        Optional<UserDTO> userDTO = userRepository.findById(id)
                .map(userMapper::toDTO);
        return userDTO.map(dto -> new Response<>(UUID.randomUUID().toString(), "Object", dto, "User record retrieved successfully."))
                .orElseGet(() -> new Response<>(UUID.randomUUID().toString(), "Object", null, "User not found."));
    }

    public Response<UserDTO> save(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return new Response<>(UUID.randomUUID().toString(), "Object", userMapper.toDTO(savedUser), "User record saved successfully.");
    }

    public Response<Boolean> deleteById(Integer id) {
        userRepository.deleteById(id);
        return new Response<>(UUID.randomUUID().toString(), "Boolean", true, "User record deleted successfully.");
    }
}
