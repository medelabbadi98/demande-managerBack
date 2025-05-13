package com.demande.demande.repos;

import com.demande.demande.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemandeRepo extends JpaRepository<Demande, UUID> {
}
