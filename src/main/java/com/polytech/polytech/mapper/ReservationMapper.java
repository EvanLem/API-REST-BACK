package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDTO toDto(Reservation reservation);
    Reservation toEntity(ReservationDTO reservationDTO);
}