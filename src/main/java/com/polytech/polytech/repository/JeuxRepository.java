package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuxRepository extends JpaRepository<Jeux, Integer> {
}