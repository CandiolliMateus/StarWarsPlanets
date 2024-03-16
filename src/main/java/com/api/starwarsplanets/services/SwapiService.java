package com.api.starwarsplanets.services;

import com.api.starwarsplanets.entity.dtos.CadastrarPlanetaRequestDto;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SwapiService {

    private final String SWAPI_BASE_URL = "https://www.swapi.tech/api/";

    public int aparicoesPlanetaNosFilmes(CadastrarPlanetaRequestDto cadastrarPlanetaRequestDto) {

        try {

            int filmesComPlaneta = 0;
            final String URL_PLANET = "planets/?name=";
            String dadosPlaneta = fetchResponseFromUrl(SWAPI_BASE_URL + URL_PLANET + cadastrarPlanetaRequestDto.getName());
            Pattern planetPattern = Pattern.compile("\"url\":\"([^\"]+)\"");
            Matcher planetMatcher = planetPattern.matcher(dadosPlaneta);
            String urlPlanetForSearch = "url do planeta";
            if (planetMatcher.find()) {
                urlPlanetForSearch = planetMatcher.group(1);
            }

            String dadosFilmes = "";
            final String URL_FILMS = "films/";
            for (int i = 1; i <= 6; i++) {
                dadosFilmes = fetchResponseFromUrl(SWAPI_BASE_URL + URL_FILMS + i);
                Pattern filmPlanetPattern = Pattern.compile("\"planets\":\\[([^\\]]+)\\]");
                Matcher filmePlanetMatcher = filmPlanetPattern.matcher(dadosFilmes);
                if (filmePlanetMatcher.find()) {
                    String planetsArray = filmePlanetMatcher.group(1);
                    if (planetsArray.contains(urlPlanetForSearch)) {
                        filmesComPlaneta++;
                    }
                }
            }
            return filmesComPlaneta;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String fetchResponseFromUrl (String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
