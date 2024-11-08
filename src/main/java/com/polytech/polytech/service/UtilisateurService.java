package com.polytech.polytech.service;

import com.polytech.polytech.dto.UtilisateurDTO;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.mapper.UtilisateurMapper;
import com.polytech.polytech.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(utilisateur);
    }

    public UtilisateurDTO getUtilisateurById(Integer id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        return utilisateurMapper.toDto(utilisateur);
    }

    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        utilisateur.setUsername(utilisateurDTO.getUsername());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setPassword(utilisateurDTO.getPassword());
        utilisateur.setMail(utilisateurDTO.getMail());
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(utilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}