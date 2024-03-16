package com.api.starwarsplanets.entity.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Planets")
public class PlanetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String climate;
    @Column(nullable = false)
    private String terrain;
    @Column(nullable = false)
    private int appearances;

    public PlanetModel() {
    }

    public PlanetModel(
            long id,
            String name,
            String climate,
            String terrain,
            int appearances) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.appearances = appearances;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }
}
