package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.ReservationDTO;
import com.polytech.polytech.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationDTO toDto(Reservation reservation);
    Reservation toEntity(ReservationDTO reservationDTO);
}