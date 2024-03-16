package com.api.starwarsplanets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ApiStarWarsPlanetsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiStarWarsPlanetsApplication.class, args);
	}
}
