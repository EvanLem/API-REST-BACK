package com.example.projet.component;

import com.example.projet.DTO.BookingDTO;
import com.example.projet.DTO.BookingDTO.BookingDTOBuilder;
import com.example.projet.entity.Booking;
import com.example.projet.entity.BookingKey;
import com.example.projet.entity.Game;
import com.example.projet.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T14:20:21+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO toDto(Booking game) {
        if ( game == null ) {
            return null;
        }

        BookingDTOBuilder bookingDTO = BookingDTO.builder();

        bookingDTO.utilisateurId( gameUserId( game ) );
        bookingDTO.jeuxId( gameGameId( game ) );
        bookingDTO.reservation( game.getReservation() );

        return bookingDTO.build();
    }

    @Override
    public Booking toEntity(BookingDTO gameDTO) {
        if ( gameDTO == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( bookingDTOToBookingKey( gameDTO ) );
        booking.setReservation( gameDTO.getReservation() );

        return booking;
    }

    private Integer gameUserId(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        User user = booking.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer gameGameId(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        Game game = booking.getGame();
        if ( game == null ) {
            return null;
        }
        Integer id = game.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected BookingKey bookingDTOToBookingKey(BookingDTO bookingDTO) {
        if ( bookingDTO == null ) {
            return null;
        }

        BookingKey bookingKey = new BookingKey();

        bookingKey.setUserId( bookingDTO.getUtilisateurId() );
        bookingKey.setGameId( bookingDTO.getJeuxId() );

        return bookingKey;
    }
}
