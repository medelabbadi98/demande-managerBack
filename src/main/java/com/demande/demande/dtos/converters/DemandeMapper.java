package com.demande.demande.dtos.converters;

import com.demande.demande.dtos.DemandeDto;
import com.demande.demande.entities.Demande;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class DemandeMapper implements IDemandeMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public DemandeDto demandeToDemandeDto(Demande demande) {
        if (demande == null) return null;

        DemandeDto dto = new DemandeDto();
        dto.setId(demande.getId().toString());
        dto.setDesignation(demande.getDesignation());
        dto.setQuantite(demande.getQuantite());
        dto.setStatus(demande.getStatus());
        dto.setCreatedAt(demande.getCreatedAt() != null ? demande.getCreatedAt().format(formatter) : null);
        dto.setUpdatedAt(demande.getUpdatedAt() != null ? demande.getUpdatedAt().format(formatter) : null);
        return dto;
    }

    @Override
    public Demande demandeDtoToDemande(DemandeDto dto) {
        if (dto == null) return null;

        Demande demande = new Demande();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            demande.setId(UUID.fromString(dto.getId()));
        }
        demande.setDesignation(dto.getDesignation());
        demande.setQuantite(dto.getQuantite());
        demande.setStatus(dto.getStatus());
        demande.setCreatedAt(dto.getCreatedAt() != null ? LocalDate.parse(dto.getCreatedAt(), formatter) : null);
        demande.setUpdatedAt(dto.getUpdatedAt() != null ? LocalDate.parse(dto.getUpdatedAt(), formatter) : null);
        return demande;
    }
}
