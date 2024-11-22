package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.ReservationDTO;
import com.polytech.polytech.dto.ReservationDTO.ReservationDTOBuilder;
import com.polytech.polytech.entity.Reservation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-08T15:16:23+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDTO toDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTOBuilder reservationDTO = ReservationDTO.builder();

        reservationDTO.reservation( reservation.getReservation() );

        return reservationDTO.build();
    }

    @Override
    public Reservation toEntity(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        if ( reservationDTO.getReservation() != null ) {
            reservation.setReservation( reservationDTO.getReservation() );
        }

        return reservation;
    }
}
