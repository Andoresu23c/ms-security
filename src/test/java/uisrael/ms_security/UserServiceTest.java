package uisrael.ms_security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.dto.UserDTO;
import uisrael.ms_security.mapper.UserMapper;
import uisrael.ms_security.model.User;
import uisrael.ms_security.repository.IUserRepository;
import uisrael.ms_security.service.UserService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1);
        user.setUsername("testuser");
        user.setDocumentType("ID");
        user.setDocument("123456789");
        user.setEmail("testuser@example.com");
        user.setPassword("password");
        user.setStatus(true);
        user.setCreatedAt(new Date());

        userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUsername("testuser");
        userDTO.setDocumentType("ID");
        userDTO.setDocument("123456789");
        userDTO.setEmail("testuser@example.com");
        userDTO.setPassword("password");
        userDTO.setStatus(true);
        userDTO.setCreatedAt(new Date());
    }

    @Test
    void testFindAll() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        Response<List<UserDTO>> response = userService.findAll();

        assertNotNull(response);
        assertEquals(1, response.getData().size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        Response<UserDTO> response = userService.findById(1);

        assertNotNull(response);
        assertNotNull(response.getData());
        assertEquals("testuser", response.getData().getUsername());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        Response<UserDTO> response = userService.save(userDTO);

        assertNotNull(response);
        assertNotNull(response.getData());
        assertEquals("testuser", response.getData().getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testDeleteById() {
        doNothing().when(userRepository).deleteById(1);

        Response<Boolean> response = userService.deleteById(1);

        assertNotNull(response);
        assertTrue(response.getData());
        verify(userRepository, times(1)).deleteById(1);
    }
}
