package com.example.projet.repository;

import com.example.projet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de gestion des utilisateurs dans la base de données.
 * <p>
 * Cette interface étend JpaRepository, ce qui permet de bénéficier des méthodes CRUD de base pour manipuler
 * les entités User dans la base de données. Des méthodes supplémentaires peuvent être définies selon les besoins.
 * </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Autres méthodes personnalisées pour la gestion des utilisateurs peuvent être ajoutées ici.
}
