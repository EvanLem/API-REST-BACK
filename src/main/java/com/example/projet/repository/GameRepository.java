package com.example.projet.repository;

import com.example.projet.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de gestion des jeux dans la base de données.
 * <p>
 * Cette interface étend JpaRepository, ce qui permet de bénéficier des méthodes CRUD de base pour manipuler
 * les entités Game dans la base de données. Des méthodes supplémentaires peuvent être définies selon les besoins.
 * </p>
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    // Autres méthodes personnalisées pour la gestion des jeux peuvent être ajoutées ici.
}
