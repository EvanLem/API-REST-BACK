package com.example.projet.controller;

import com.example.projet.DTO.BookingDTO;
import com.example.projet.service.BookingService;
import com.example.projet.exception.ApiError;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux réservations.
 * <p>
 * Fournit des endpoints pour récupérer, ajouter, mettre à jour et supprimer des réservations.
 * Gère les erreurs et retourne des réponses appropriées avec des détails sur les erreurs.
 */
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Récupère toutes les réservations.
     *
     * @return Une réponse avec la liste des réservations sous forme de BookingDTO.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getBooking() {
        try {
            List<BookingDTO> gameList = bookingService.getAllBookings();
            return new ResponseEntity<>(gameList, HttpStatus.OK);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Récupère une réservation spécifique en fonction de l'identifiant utilisateur et de l'identifiant du jeu.
     *
     * @param userId L'identifiant de l'utilisateur.
     * @param gameId L'identifiant du jeu.
     * @return Une réponse avec les données de la réservation.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @GetMapping("/{userId}/{gameId}")
    public ResponseEntity<?> getBooking(@PathVariable Integer userId, @PathVariable Integer gameId) {
        try {
            return ResponseEntity.ok(bookingService.getBooking(userId, gameId));
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Récupère une réservation spécifique par son identifiant.
     *
     * @param bookingId L'identifiant de la réservation.
     * @return Une réponse avec les données de la réservation.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingById(@PathVariable Integer bookingId) {
        try {
            return ResponseEntity.ok(bookingService.getBookingById(bookingId));
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Ajoute une nouvelle réservation.
     *
     * @param bookingDTO Les données de la réservation à ajouter.
     * @return Une réponse avec la réservation créée.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            return new ResponseEntity<>(bookingService.createBooking(bookingDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (EntityExistsException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.CONFLICT.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Supprime une réservation spécifique.
     *
     * @param userId L'identifiant de l'utilisateur.
     * @param gameId L'identifiant du jeu.
     * @return Une réponse sans contenu.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @DeleteMapping("/{userId}/{gameId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer userId, @PathVariable Integer gameId) {
        try {
            bookingService.deleteBooking(userId, gameId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Met à jour une réservation existante.
     *
     * @param userId      L'identifiant de l'utilisateur.
     * @param gameId      L'identifiant du jeu.
     * @param bookingDTO  Les nouvelles données de la réservation.
     * @return Une réponse avec la réservation mise à jour.
     *         En cas d'erreur, retourne une réponse avec un ApiError.
     */
    @PutMapping("/{userId}/{gameId}")
    public ResponseEntity<?> updateBooking(@PathVariable Integer userId, @PathVariable Integer gameId, @RequestBody BookingDTO bookingDTO) {
        try {
            return new ResponseEntity<>(bookingService.updateBooking(userId, gameId, bookingDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
