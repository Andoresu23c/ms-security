package uisrael.ms_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uisrael.ms_security.dto.ProfileDTO;
import uisrael.ms_security.dto.Response;
import uisrael.ms_security.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("api/ms-security/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<Response<List<ProfileDTO>>> getAllProfiles() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ProfileDTO>> getProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(profileService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Response<ProfileDTO>> createProfile(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.save(profileDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<ProfileDTO>> updateProfile(@PathVariable Integer id, @RequestBody ProfileDTO profileDetails) {
        Response<ProfileDTO> profileResponse = profileService.findById(id);
        if (profileResponse.getData() != null) {
            profileDetails.setId(id);
            return ResponseEntity.ok(profileService.save(profileDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deleteProfile(@PathVariable Integer id) {
        return ResponseEntity.ok(profileService.deleteById(id));
    }
}
