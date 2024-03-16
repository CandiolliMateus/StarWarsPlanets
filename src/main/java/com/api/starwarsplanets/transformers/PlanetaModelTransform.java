package com.api.starwarsplanets.transformers;

import com.api.starwarsplanets.entity.dtos.CadastrarPlanetaRequestDto;
import com.api.starwarsplanets.entity.models.PlanetModel;
import com.api.starwarsplanets.services.SwapiService;

public class PlanetaModelTransform {

    public PlanetModel transformerCadastrarPlaneta(CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto) {

        SwapiService swapiService = new SwapiService();
        PlanetModel planetModel = new PlanetModel();
        int aparicoesPlaneta = swapiService.aparicoesPlanetaNosFilmes(cadastrarPlanetaRequestDto);

        planetModel.setName(cadastrarPlanetaRequestDto.getName());
        planetModel.setClimate(cadastrarPlanetaRequestDto.getClimate());
        planetModel.setTerrain(cadastrarPlanetaRequestDto.getTerrain());
        planetModel.setAppearances(Integer.parseInt(String.valueOf(aparicoesPlaneta)));
        return planetModel;
    }
}
