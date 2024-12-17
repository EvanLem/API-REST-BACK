package com.example.projet.service;

import com.example.projet.DTO.BookingDTO;
import com.example.projet.entity.Booking;
import com.example.projet.entity.BookingKey;
import com.example.projet.entity.User;
import com.example.projet.entity.Game;
import com.example.projet.repository.BookingRepository;
import com.example.projet.repository.UserRepository;
import com.example.projet.repository.GameRepository;
import com.example.projet.component.BookingMapper;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service de gestion des réservations.
 * <p>
 * Cette classe fournit des méthodes pour gérer les réservations de jeux par les utilisateurs. Elle inclut des opérations CRUD
 * pour l'entité Booking.
 * </p>
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private BookingMapper bookingMapper;

    /**
     * Récupère toutes les réservations.
     * @return une liste de DTO des réservations
     */
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Récupère une réservation spécifique basée sur l'id de l'utilisateur et l'id du jeu.
     * @param userId l'id de l'utilisateur
     * @param gameId l'id du jeu
     * @return un DTO de la réservation
     */
    public BookingDTO getBooking(Integer userId, Integer gameId) {
        BookingKey key = new BookingKey(userId, gameId);
        return bookingRepository.findById(key)
                .map(bookingMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Bookings not found"));
    }

    /**
     * Récupère une réservation basée sur l'id de la réservation.
     * @param bookingId l'id de la réservation
     * @return un DTO de la réservation
     */
    public BookingDTO getBookingById(Integer bookingId) {
        return bookingRepository.findByReservation(bookingId)
                .map(bookingMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Bookings not found"));
    }

    /**
     * Crée une nouvelle réservation.
     * <p>
     * Vérifie si la réservation existe déjà. Si la réservation existe ou si les informations sont incorrectes,
     * une exception est levée.
     * </p>
     * @param bookingDTO les informations de la réservation à créer
     * @return le DTO de la réservation créée
     */
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        // Vérifie si la réservation existe déjà, si oui alors on retourne une erreur
        if (existBooking(bookingDTO.getReservation()))
            throw new EntityExistsException(String.format("Booking with id = %d already exists", bookingDTO.getReservation()));

        // Vérifie si le champ réservation n'est pas null
        if (bookingDTO.getReservation() == null)
            throw new IllegalArgumentException("Reservation ID must not be null");

        // Récupérer l'utilisateur et le jeu correspondants
        User user = userRepository.findById(Math.toIntExact(bookingDTO.getUtilisateurId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Game game = gameRepository.findById(Math.toIntExact(bookingDTO.getJeuxId()))
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));

        // Créer l'entité Booking
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking.setUser(user);
        booking.setGame(game);
        booking = bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }

    /**
     * Met à jour une réservation existante.
     * <p>
     * Recherche la réservation à modifier et met à jour ses informations.
     * </p>
     * @param userId l'id de l'utilisateur
     * @param gameId l'id du jeu
     * @param bookingDTO les nouvelles informations de la réservation
     * @return le DTO de la réservation mise à jour
     */
    public BookingDTO updateBooking(Integer userId, Integer gameId, BookingDTO bookingDTO) {
        // On récupère la clé primaire de la réservation à modifier
        BookingKey key = new BookingKey(userId, gameId);
        // On récupère la nouvelle clé primaire
        BookingKey newKey = new BookingKey(bookingDTO.getUtilisateurId(), bookingDTO.getJeuxId());

        // On cherche les éléments existants
        Booking booking = bookingRepository.findById(key)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));

        // On met à jour les informations de la réservation
        booking.setReservation(bookingDTO.getReservation());
        booking.setId(newKey);
        booking.setUser(user);
        booking.setGame(game);
        // Sauvegarde
        bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }

    /**
     * Supprime une réservation existante.
     * @param userId l'id de l'utilisateur
     * @param gameId l'id du jeu
     */
    public void deleteBooking(Integer userId, Integer gameId) {
        BookingKey key = new BookingKey(userId, gameId);
        bookingRepository.deleteById(key);
    }

    /**
     * Vérifie si une réservation existe déjà en fonction de l'id de réservation.
     * @param bookingId l'id de la réservation à vérifier
     * @return vrai si la réservation existe, sinon faux
     */
    public boolean existBooking(Integer bookingId) {
        return bookingRepository.existsByReservation(bookingId);
    }
}
