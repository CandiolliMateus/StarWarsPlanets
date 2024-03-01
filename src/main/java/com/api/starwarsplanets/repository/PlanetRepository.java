package com.api.starwarsplanets.repository;

import com.api.starwarsplanets.model.PlanetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<PlanetModel, Integer> {
}
