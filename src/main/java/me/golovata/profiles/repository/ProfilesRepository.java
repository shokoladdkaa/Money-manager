package me.golovata.profiles.repository;

import me.golovata.profiles.model.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<Profiles, Integer> {
}
