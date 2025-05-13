package com.demande.demande.services;

import com.demande.demande.dtos.DemandeDto;
import com.demande.demande.dtos.converters.IDemandeMapper;
import com.demande.demande.entities.Demande;
import com.demande.demande.repos.DemandeRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DemandeService implements IDemande {

    private final DemandeRepo repo;

    private final IDemandeMapper mapper;

    public DemandeService(DemandeRepo repo, IDemandeMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void deleteDemande(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public DemandeDto getDemandeById(UUID id) {
        return mapper.demandeToDemandeDto(repo.getById(id));
    }

    @Override
    public List<DemandeDto> getAllDemandes() {
        return repo.findAll().stream().map(demande -> mapper.demandeToDemandeDto(demande)).collect(Collectors.toList()) ;
    }

    @Override
    public DemandeDto createDemande(DemandeDto demand) {

        Demande demande = mapper.demandeDtoToDemande(demand);
        Demande persist = repo.save(demande);
        return mapper.demandeToDemandeDto(persist);
    }

    @Override
    public DemandeDto updateDemande(UUID id, DemandeDto demand) {
        Optional<Demande> optional = repo.findById(id);
        if (optional.isPresent()) {
            throw new RuntimeException();
        }

        Demande updateDemande = new Demande();
        updateDemande.setQuantite(demand.getQuantite());
        updateDemande.setDesignation(demand.getDesignation());
        updateDemande.setStatus(demand.getStatus());
        updateDemande.setUpdatedAt(LocalDate.now());
        Demande persist = repo.save(updateDemande);
        return mapper.demandeToDemandeDto(persist);
    }
}
