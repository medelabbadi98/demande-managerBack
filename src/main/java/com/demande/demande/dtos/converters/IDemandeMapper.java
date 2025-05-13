package com.demande.demande.dtos.converters;

import com.demande.demande.dtos.DemandeDto;
import com.demande.demande.entities.Demande;

public interface IDemandeMapper {
    DemandeDto demandeToDemandeDto(Demande demande);
    Demande demandeDtoToDemande(DemandeDto dto);
}
