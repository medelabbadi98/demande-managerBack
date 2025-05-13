package com.demande.demande.services;

import com.demande.demande.dtos.DemandeDto;

import java.util.List;
import java.util.UUID;

public interface IDemande {
    void deleteDemande(UUID id);
    DemandeDto getDemandeById(UUID id);
    List<DemandeDto> getAllDemandes();
    DemandeDto createDemande(DemandeDto demand);
    DemandeDto updateDemande(UUID id, DemandeDto demand);

}
