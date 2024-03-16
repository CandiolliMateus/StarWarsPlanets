package com.api.starwarsplanets.services;

import com.api.starwarsplanets.base.dto.BaseDto;
import com.api.starwarsplanets.base.dto.BaseErrorDto;
import com.api.starwarsplanets.builder.ResponseErrorBuilder;
import com.api.starwarsplanets.builder.ResponseSuccessBuilder;
import com.api.starwarsplanets.constants.MensagensErros;
import com.api.starwarsplanets.constants.MensagensSucessos;
import com.api.starwarsplanets.entity.dtos.CadastraPlanetaResponseDto;
import com.api.starwarsplanets.entity.dtos.CadastrarPlanetaRequestDto;
import com.api.starwarsplanets.entity.models.PlanetModel;
import com.api.starwarsplanets.repositories.PlanetRepository;
import com.api.starwarsplanets.transformers.PlanetaModelTransform;
import com.api.starwarsplanets.validate.CadastrarPlanetaValidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarPlanetaService {

    private PlanetRepository planetRepository;

    public CadastrarPlanetaService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public ResponseEntity cadastrarPlaneta(CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto) {
        List<BaseErrorDto> erros = new CadastrarPlanetaValidate().validate(cadastrarPlanetaRequestDto);
        if (erros.size() > 0) {
            ResponseErrorBuilder resultado = new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros);
            return resultado.getResultado();
        }

        if (planetRepository.existsByName(cadastrarPlanetaRequestDto.getName()).orElse(false)) {
            erros.add(new BaseErrorDto("Name", MensagensErros.PLANETA_EXISTENTE));
        }
        if (erros.size() > 0) {
            ResponseErrorBuilder resultado = new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros);
            return resultado.getResultado();
        }

        PlanetModel planetaSalvo = new PlanetaModelTransform().transformerCadastrarPlaneta(cadastrarPlanetaRequestDto);
        long idPlanetaSalvo = planetRepository.save(planetaSalvo).getId();

        ResponseSuccessBuilder cadastradoComSucesso = new ResponseSuccessBuilder<CadastraPlanetaResponseDto>(
                HttpStatus.CREATED,
                new CadastraPlanetaResponseDto(String.format("%d", idPlanetaSalvo)),
                MensagensSucessos.CADASTRADO_COM_SUCESSO
        );
        return cadastradoComSucesso.getResultado();
    }
}
