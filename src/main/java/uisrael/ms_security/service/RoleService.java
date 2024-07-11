package uisrael.ms_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.dto.RoleDTO;
import uisrael.ms_security.mapper.RoleMapper;
import uisrael.ms_security.model.Role;
import uisrael.ms_security.repository.IRoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public Response<List<RoleDTO>> findAll() {
        List<RoleDTO> roles = roleRepository.findAll().stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
        return new Response<>(UUID.randomUUID().toString(), "Object List", roles, "Role records retrieved successfully.");
    }

    public Response<RoleDTO> findById(Integer id) {
        Optional<RoleDTO> roleDTO = roleRepository.findById(id)
                .map(roleMapper::toDTO);
        return roleDTO.map(dto -> new Response<>(UUID.randomUUID().toString(), "Object", dto, "Role record retrieved successfully."))
                .orElseGet(() -> new Response<>(UUID.randomUUID().toString(), "Object", null, "Role not found."));
    }

    public Response<RoleDTO> save(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        Role savedRole = roleRepository.save(role);
        return new Response<>(UUID.randomUUID().toString(), "Object", roleMapper.toDTO(savedRole), "Role record saved successfully.");
    }
}
