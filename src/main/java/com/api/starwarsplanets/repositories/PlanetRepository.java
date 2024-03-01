package com.api.starwarsplanets.repositories;

import com.api.starwarsplanets.models.PlanetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<PlanetModel, Long> {
}
