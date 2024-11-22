package com.polytech.polytech.service;

import com.polytech.polytech.dto.JeuxDTO;
import com.polytech.polytech.entity.Jeux;
import com.polytech.polytech.mapper.JeuxMapper;
import com.polytech.polytech.repository.JeuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JeuxService {

    @Autowired
    private JeuxRepository jeuxRepository;

    @Autowired
    private JeuxMapper jeuxMapper;

    public JeuxDTO createJeux(JeuxDTO jeuxDTO) {
        Jeux jeux = jeuxMapper.toEntity(jeuxDTO);
        jeux = jeuxRepository.save(jeux);
        return jeuxMapper.toDto(jeux);
    }

    public JeuxDTO getJeuxById(Integer id) {
        Jeux jeux = jeuxRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        return jeuxMapper.toDto(jeux);
    }

    public List<JeuxDTO> getAllJeux() {
        return jeuxRepository.findAll().stream()
                .map(jeuxMapper::toDto)
                .collect(Collectors.toList());
    }

    public JeuxDTO updateJeux(Integer id, JeuxDTO jeuxDTO) {
        Jeux jeux = jeuxRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeux not found"));
        jeux.setNom(jeuxDTO.getNom());
        jeux.setQuantite(jeuxDTO.getQuantite());
        jeux.setDescription(jeuxDTO.getDescription());
        jeux.setPoint_geo(jeuxDTO.getPoint_geo()); // Assurez-vous que ce champ est mis à jour
        jeux = jeuxRepository.save(jeux);
        return jeuxMapper.toDto(jeux);
    }

    public void deleteJeux(Integer id) {
        jeuxRepository.deleteById(id);
    }
}