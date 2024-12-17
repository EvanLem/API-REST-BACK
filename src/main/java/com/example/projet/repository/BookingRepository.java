package com.example.projet.repository;

import com.example.projet.entity.Booking;
import com.example.projet.entity.BookingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface de gestion des réservations dans la base de données.
 * <p>
 * Cette interface étend JpaRepository, ce qui permet de bénéficier des méthodes CRUD de base pour manipuler
 * les entités Booking dans la base de données. Elle définit également des méthodes
 * pour rechercher et vérifier les réservations par leur attribut reservation.
 * </p>
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, BookingKey> {

    /**
     * Trouve une réservation par son numéro de réservation.
     *
     * @param reservation Le numéro de réservation.
     * @return Une option avec la réservation si elle est trouvée, sinon vide.
     */
    Optional<Booking> findByReservation(Integer reservation);

    /**
     * Vérifie si une réservation existe déjà pour un numéro donné.
     *
     * @param reservation Le numéro de réservation.
     * @return true si une réservation existe, sinon false.
     */
    boolean existsByReservation(Integer reservation);
}
