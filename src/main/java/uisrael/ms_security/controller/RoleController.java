package uisrael.ms_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.dto.RoleDTO;
import uisrael.ms_security.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("api/ms-security/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<Response<List<RoleDTO>>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<RoleDTO>> getRoleById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Response<RoleDTO>> createRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.save(roleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<RoleDTO>> updateRole(@PathVariable Integer id, @RequestBody RoleDTO roleDetails) {
        Response<RoleDTO> roleResponse = roleService.findById(id);
        if (roleResponse.getData() != null) {
            roleDetails.setId(id);
            return ResponseEntity.ok(roleService.save(roleDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Response<Boolean>> deleteRole(@PathVariable Integer id) {
//        return ResponseEntity.ok(roleService.(id));
//    }
}
