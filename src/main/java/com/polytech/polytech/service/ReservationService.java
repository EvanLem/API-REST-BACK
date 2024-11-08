package com.polytech.polytech.service;

import com.polytech.polytech.dto.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.exception.ResourceNotFoundException;
import com.polytech.polytech.mapper.ReservationMapper;
import com.polytech.polytech.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        reservation = reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    public ReservationDTO getReservationById(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
        return reservationMapper.toDto(reservation);
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReservationDTO updateReservation(Integer id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
        reservation.setUtilisateurId(reservationDTO.getUtilisateur_id());
        reservation.setJeuxId(reservationDTO.getJeuxid());
        reservation = reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    public void deleteReservation(Integer id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation not found");
        }
        reservationRepository.deleteById(id);
    }
}