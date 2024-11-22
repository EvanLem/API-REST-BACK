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
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookingDTO getBooking(Integer userId, Integer gameId) {
        BookingKey key = new BookingKey(userId, gameId);
        return bookingRepository.findById(key).map(bookingMapper::toDto).orElseThrow(() -> new RuntimeException("Bookings not found"));
    }

    public BookingDTO getBookingById(Integer bookingId) {
        return bookingRepository.findByReservation(bookingId).map(bookingMapper::toDto).orElseThrow(() -> new RuntimeException("Bookings not found"));
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        // Vérifie si la réservation existe déjà, si oui alors on retourne une erreur
        if (existBooking(bookingDTO.getReservation())) throw new EntityExistsException(String.format("Booking with id = %d already exists", bookingDTO.getReservation()));

        // Vérifie si le champ réservation n'est pas null
        if (bookingDTO.getReservation() == null) throw new IllegalArgumentException("Reservation ID must not be null");

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

    public void deleteBooking(Integer userId, Integer gameId) {
        BookingKey key = new BookingKey(userId, gameId);
        bookingRepository.deleteById(key);
    }

    public boolean existBooking (Integer bookingId) {
        return bookingRepository.existsByReservation(bookingId);
    }
}
