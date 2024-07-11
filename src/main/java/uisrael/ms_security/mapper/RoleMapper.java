package uisrael.ms_security.mapper;

import org.springframework.stereotype.Component;
import uisrael.ms_security.dto.RoleDTO;
import uisrael.ms_security.model.Role;

@Component
public class RoleMapper {
    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        roleDTO.setCreatedAt(role.getCreatedAt());
        roleDTO.setStatus(role.getStatus());
        return roleDTO;
    }

    public Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        role.setCreatedAt(roleDTO.getCreatedAt());
        role.setStatus(roleDTO.getStatus());
        return role;
    }
}
