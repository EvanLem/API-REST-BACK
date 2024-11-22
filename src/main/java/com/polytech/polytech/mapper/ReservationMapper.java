package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(ReservationDTO reservationDTO);
    ReservationDTO toDto(Reservation reservation);
}