package com.api.starwarsplanets.repositories;

import com.api.starwarsplanets.entity.models.PlanetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<PlanetModel, Long> {
    Optional<Boolean> existsByName(String name);
}
