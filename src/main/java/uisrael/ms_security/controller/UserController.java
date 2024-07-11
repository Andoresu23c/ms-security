package uisrael.ms_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.dto.UserDTO;
import uisrael.ms_security.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/ms-security/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Response<List<UserDTO>>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Response<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDetails) {
        Response<UserDTO> userResponse = userService.findById(id);
        if (userResponse.getData() != null) {
            userDetails.setId(id);
            return ResponseEntity.ok(userService.save(userDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
