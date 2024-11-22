package com.example.projet.repository;

import com.example.projet.entity.Booking;
import com.example.projet.entity.BookingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, BookingKey> {
    Optional<Booking> findByReservation(Integer reservation);

    boolean existsByReservation(Integer reservation);
}
