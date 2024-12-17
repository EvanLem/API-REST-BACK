package com.example.projet.controller;

import com.example.projet.DTO.UserDTO;
import com.example.projet.component.UserMapper;
import com.example.projet.exception.ApiError;
import com.example.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getUsers() {
        try {
            List<UserDTO> users = userService.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
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

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        try {
            System.out.println(userDTO.toString());
            return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        try {
            return new ResponseEntity<>(userService.updateUser(id, userDTO), HttpStatus.OK);
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
