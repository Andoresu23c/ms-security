package uisrael.ms_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uisrael.ms_security.dto.ProfileDTO;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.mapper.ProfileMapper;
import uisrael.ms_security.model.Profile;
import uisrael.ms_security.repository.IProfileRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfileService {
    @Autowired
    private IProfileRepository profileRepository;

    @Autowired
    private ProfileMapper profileMapper;

    public Response<List<ProfileDTO>> findAll() {
        List<ProfileDTO> profiles = profileRepository.findAll().stream()
                .map(profileMapper::toDTO)
                .collect(Collectors.toList());
        return new Response<>(UUID.randomUUID().toString(), "Object List", profiles, "Profile records retrieved successfully.");
    }

    public Response<ProfileDTO> findById(Integer id) {
        Optional<ProfileDTO> profileDTO = profileRepository.findById(id)
                .map(profileMapper::toDTO);
        return profileDTO.map(dto -> new Response<>(UUID.randomUUID().toString(), "Object", dto, "Profile record retrieved successfully."))
                .orElseGet(() -> new Response<>(UUID.randomUUID().toString(), "Object", null, "Profile not found."));
    }

    public Response<ProfileDTO> save(ProfileDTO profileDTO) {
        Profile profile = profileMapper.toEntity(profileDTO);
        Profile savedProfile = profileRepository.save(profile);
        return new Response<>(UUID.randomUUID().toString(), "Object", profileMapper.toDTO(savedProfile), "Profile record saved successfully.");
    }

    public Response<Boolean> deleteById(Integer id) {
        profileRepository.deleteById(id);
        return new Response<>(UUID.randomUUID().toString(), "Boolean", true, "Profile record deleted successfully.");
    }
}
