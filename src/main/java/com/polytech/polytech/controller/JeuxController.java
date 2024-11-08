package com.polytech.polytech.controller;

import com.polytech.polytech.dto.JeuxDTO;
import com.polytech.polytech.service.JeuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jeux")
public class JeuxController {

    @Autowired
    private JeuxService jeuxService;

    @PostMapping
    public ResponseEntity<JeuxDTO> createJeux(@RequestBody JeuxDTO jeuxDTO) {
        JeuxDTO createdJeux = jeuxService.createJeux(jeuxDTO);
        return ResponseEntity.ok(createdJeux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeuxDTO> getJeuxById(@PathVariable Integer id) {
        JeuxDTO jeuxDTO = jeuxService.getJeuxById(id);
        return ResponseEntity.ok(jeuxDTO);
    }

    @GetMapping
    public ResponseEntity<List<JeuxDTO>> getAllJeux() {
        List<JeuxDTO> jeuxList = jeuxService.getAllJeux();
        return ResponseEntity.ok(jeuxList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JeuxDTO> updateJeux(@PathVariable Integer id, @RequestBody JeuxDTO jeuxDTO) {
        JeuxDTO updatedJeux = jeuxService.updateJeux(id, jeuxDTO);
        return ResponseEntity.ok(updatedJeux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJeux(@PathVariable Integer id) {
        jeuxService.deleteJeux(id);
        return ResponseEntity.noContent().build();
    }
}