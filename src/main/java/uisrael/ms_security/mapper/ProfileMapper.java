package uisrael.ms_security.mapper;

import org.springframework.stereotype.Component;
import uisrael.ms_security.dto.ProfileDTO;
import uisrael.ms_security.model.Profile;
import uisrael.ms_security.model.Role;
import uisrael.ms_security.model.User;
import uisrael.ms_security.repository.IRoleRepository;
import uisrael.ms_security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProfileMapper {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public ProfileDTO toDTO(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setUserId(profile.getUser().getId());
        profileDTO.setRoleId(profile.getRole().getId());
        return profileDTO;
    }

    public Profile toEntity(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setId(profileDTO.getId());
        User user = userRepository.findById(profileDTO.getUserId()).orElse(null);
        Role role = roleRepository.findById(profileDTO.getRoleId()).orElse(null);
        profile.setUser(user);
        profile.setRole(role);
        return profile;
    }
}
