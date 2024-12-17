package com.example.projet.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Représente une erreur d'API qui contient des informations sur l'état de la réponse,
 * le message d'erreur et l'horodatage de l'erreur.
 */
@Getter
@Setter
public class ApiError {

    /**
     * Le code de statut HTTP de l'erreur (ex: 404, 500, etc.).
     */
    private int status;

    /**
     * Le message d'erreur détaillant la cause du problème.
     */
    private String message;

    /**
     * L'horodatage de l'erreur, indiquant le moment où l'erreur s'est produite.
     */
    private String timestamp;


    /**
     * Constructeur pour initialiser un objet ApiError avec les valeurs spécifiées.
     *
     * @param status Le code de statut HTTP.
     * @param message Le message d'erreur détaillant la cause de l'erreur.
     * @param timestamp L'horodatage de l'erreur.
     */
    public ApiError(int status, String message, String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
