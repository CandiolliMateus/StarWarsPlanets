package com.api.starwarsplanets.validate;

import com.api.starwarsplanets.base.dto.BaseErrorDto;
import com.api.starwarsplanets.constants.MensagensErros;
import com.api.starwarsplanets.entity.dtos.CadastrarPlanetaRequestDto;

import java.util.ArrayList;
import java.util.List;

public class CadastrarPlanetaValidate {
    public List<BaseErrorDto> validate(CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto) {
        List<BaseErrorDto> erros = validarCamposRequeridos(cadastrarPlanetaRequestDto);
        return erros.size() > 0 ? erros : validarCamposInvalidos(cadastrarPlanetaRequestDto, erros);
    }

    private List<BaseErrorDto> validarCamposRequeridos(CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto) {
        List<BaseErrorDto> erros = new ArrayList<>();

        if (cadastrarPlanetaRequestDto.getName() == null || cadastrarPlanetaRequestDto.getName().isEmpty()) {
            erros.add(new BaseErrorDto("Name", MensagensErros.CAMPO_OBRIGATORIO));
        }
        if (cadastrarPlanetaRequestDto.getClimate() == null || cadastrarPlanetaRequestDto.getClimate().isEmpty()) {
            erros.add(new BaseErrorDto("Climate", MensagensErros.CAMPO_OBRIGATORIO));
        }
        if (cadastrarPlanetaRequestDto.getTerrain() == null || cadastrarPlanetaRequestDto.getTerrain().isEmpty()) {
            erros.add(new BaseErrorDto("Terrain", MensagensErros.CAMPO_OBRIGATORIO));
        }

        return erros;
    }

    private List<BaseErrorDto> validarCamposInvalidos(
            CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto,
            List<BaseErrorDto> erros) {

        if (cadastrarPlanetaRequestDto.getAppearances() != null && !cadastrarPlanetaRequestDto.getAppearances().isEmpty()) {
            erros.add(new BaseErrorDto("Appearances", MensagensErros.CAMPO_INVALIDO));
        }
        return erros;
    }
}
