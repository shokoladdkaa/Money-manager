package me.golovata.profiles.controller;

import me.golovata.profiles.model.Profiles;
import me.golovata.profiles.repository.ProfilesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfilesController {

    private final ProfilesRepository profilesRepository;

    public ProfilesController(ProfilesRepository profilesRepository) {
        this.profilesRepository = profilesRepository;
    }

    @GetMapping("/profiles")
    public List<Profiles> findAllUsers() {
        return profilesRepository.findAll();
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profiles> createUser(@RequestBody Profiles newProfiles) {
        Profiles profiles = profilesRepository.save(newProfiles);
        return new ResponseEntity<>(profiles, HttpStatus.CREATED);
    }
}
