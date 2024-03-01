package com.api.starwarsplanets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// @Configuration
public class DatabaseConfig {

    @Value("${database.configuration.path}")
    private String configurationFilePath;

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    public DatabaseConfig() {
        loadDatabaseConfig();
    }

    private void loadDatabaseConfig() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getResourceAsStream(configurationFilePath);
            if (inputStream != null) {
                properties.load(inputStream);
                dbUrl = properties.getProperty("dbUrl");
                dbUsername = properties.getProperty("dbUsername");
                dbPassword = properties.getProperty("dbPassword");
            } else {
                throw new IOException("Arquivo configuration.properties não encontrado.");
            }
        } catch(IOException e){
            System.err.println("Erro ao carregar configurações do banco de dados:");
            e.printStackTrace();
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
