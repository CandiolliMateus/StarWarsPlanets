package com.api.starwarsplanets.entity.dtos;

public class CadastrarPlanetaRequestDto {

    private String name;
    private String climate;
    private String terrain;
    private String appearances;

    public CadastrarPlanetaRequestDto() {
    }

    public CadastrarPlanetaRequestDto(
            String name,
            String climate,
            String terrain,
            String appearances) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.appearances = appearances;
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

    public String getAppearances() {
        return appearances;
    }

    public void setAppearances(String appearances) {
        this.appearances = appearances;
    }
}
