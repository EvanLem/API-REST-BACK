package com.example.projet.controller;

import com.example.projet.DTO.BookingDTO;
import com.example.projet.service.BookingService;
import com.example.projet.exception.ApiError;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(produces="application/json")
    public ResponseEntity<?> getBooking() {
        try {
            List<BookingDTO> gameList = bookingService.getAllBookings();
            return new ResponseEntity<>(gameList, HttpStatus.OK);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}/{gameId}")
    public ResponseEntity<?> getBooking(@PathVariable Integer userId, @PathVariable Integer gameId) {
        try {
            return ResponseEntity.ok(bookingService.getBooking(userId, gameId));
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingById(@PathVariable Integer bookingId) {
        try {
            return ResponseEntity.ok(bookingService.getBookingById(bookingId));
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            return new ResponseEntity<>(bookingService.createBooking(bookingDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (EntityExistsException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.CONFLICT.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userId}/{gameId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer userId, @PathVariable Integer gameId) {
        try {
            bookingService.deleteBooking(userId, gameId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userId}/{gameId}")
    public ResponseEntity<?> updateBooking(@PathVariable Integer userId, @PathVariable Integer gameId, @RequestBody BookingDTO bookingDTO) {
        try {
            return new ResponseEntity<>(bookingService.updateBooking(userId, gameId, bookingDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
