package com.api.starwarsplanets.controller;

import com.api.starwarsplanets.base.dto.BaseDto;
import com.api.starwarsplanets.entity.dtos.CadastrarPlanetaRequestDto;
import com.api.starwarsplanets.entity.models.PlanetModel;
import com.api.starwarsplanets.services.CadastrarPlanetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    CadastrarPlanetaService cadastrarPlanetaService;

    public StarWarsController(CadastrarPlanetaService cadastrarPlanetaService) {
        this.cadastrarPlanetaService = cadastrarPlanetaService;
    }

    @PostMapping
    public ResponseEntity<BaseDto<PlanetModel>> cadastrarPlaneta(@RequestBody CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto) {
        ResponseEntity<BaseDto<PlanetModel>> resultado = cadastrarPlanetaService.cadastrarPlaneta(cadastrarPlanetaRequestDto);
        return resultado;
    }
}
