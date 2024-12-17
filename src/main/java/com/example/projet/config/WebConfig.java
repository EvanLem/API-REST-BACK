package com.example.projet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration pour le traitement des Cross-Origin Resource Sharing (CORS) dans l'application.
 */
@Configuration
public class WebConfig {

    /**
     * Définit un WebMvcConfigurer pour configurer les mappings CORS.
     *
     * @return Un objet WebMvcConfigurer configuré pour gérer les règles CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * Configure les règles CORS pour les routes de l'API.
             * <p>
             *Autorise uniquement les requêtes provenant de l'origine <code><a href="http://localhost:4200">...</a></code>.
             *Permet les méthodes HTTP : GET, POST, PUT, DELETE et OPTIONS.
             *
             * @param registry L'objet CorsRegistry utilisé pour enregistrer les règles CORS.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Définit les endpoints affectés par les règles CORS
                        .allowedOrigins("http://localhost:4200") // Autorise cette origine spécifique (exemple : frontend Angular local)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Méthodes HTTP autorisées
            }
        };
    }
}
