package uisrael.ms_security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import uisrael.ms_security.controller.UserController;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.dto.UserDTO;
import uisrael.ms_security.service.UserService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void testGetAllUsers() {
        when(userService.findAll()).thenReturn(new Response<>(UUID.randomUUID().toString(), "Object List", Arrays.asList(userDTO), "User records retrieved successfully."));

        ResponseEntity<Response<List<UserDTO>>> response = userController.getAllUsers();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getData().size());
        verify(userService, times(1)).findAll();
    }

    @Test
    void testGetUserById() {
        when(userService.findById(1)).thenReturn(new Response<>(UUID.randomUUID().toString(), "Object", userDTO, "User record retrieved successfully."));

        ResponseEntity<Response<UserDTO>> response = userController.getUserById(1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("testuser", response.getBody().getData().getUsername());
        verify(userService, times(1)).findById(1);
    }

    @Test
    void testCreateUser() {
        when(userService.save(any(UserDTO.class))).thenReturn(new Response<>(UUID.randomUUID().toString(), "Object", userDTO, "User record saved successfully."));

        ResponseEntity<Response<UserDTO>> response = userController.createUser(userDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("testuser", response.getBody().getData().getUsername());
        verify(userService, times(1)).save(any(UserDTO.class));
    }

    @Test
    void testUpdateUser() {
        when(userService.findById(1)).thenReturn(new Response<>(UUID.randomUUID().toString(), "Object", userDTO, "User record retrieved successfully."));
        when(userService.save(any(UserDTO.class))).thenReturn(new Response<>(UUID.randomUUID().toString(), "Object", userDTO, "User record saved successfully."));

        ResponseEntity<Response<UserDTO>> response = userController.updateUser(1, userDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("testuser", response.getBody().getData().getUsername());
        verify(userService, times(1)).findById(1);
        verify(userService, times(1)).save(any(UserDTO.class));
    }

    @Test
    void testDeleteUser() {
        when(userService.deleteById(1)).thenReturn(new Response<>(UUID.randomUUID().toString(), "Boolean", true, "User record deleted successfully."));

        ResponseEntity<Response<Boolean>> response = userController.deleteUser(1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(true, response.getBody().getData());
        verify(userService, times(1)).deleteById(1);
    }
}
