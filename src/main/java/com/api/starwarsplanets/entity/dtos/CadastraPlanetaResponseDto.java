package com.api.starwarsplanets.entity.dtos;

public class CadastraPlanetaResponseDto {

    private String planetaId;

    public CadastraPlanetaResponseDto() {
    }

    public CadastraPlanetaResponseDto(String planetaId) {
        this.planetaId = planetaId;
    }

    public String getPlanetaId() {
        return planetaId;
    }

    public void setPlanetaId(String planetaId) {
        this.planetaId = planetaId;
    }
}
