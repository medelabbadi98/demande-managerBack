package com.demande.demande.controllers;

import com.demande.demande.dtos.DemandeDto;
import com.demande.demande.services.IDemande;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/v1/demandes")
public class DemandeController {

    private final IDemande demandeService;

    public DemandeController(IDemande demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping
    public ResponseEntity<List<DemandeDto>> getDemandes() {
        return ResponseEntity.ok().body(demandeService.getAllDemandes());
    }

    @RequestMapping(value = "/dm/{demandeId}", method = RequestMethod.GET)
    public ResponseEntity<DemandeDto> getDemandeById(@PathVariable String demandeId) throws Exception {
        return ResponseEntity.ok().body(demandeService.getDemandeById(UUID.fromString(demandeId)));
    }

    @RequestMapping(value = "/demande", method = RequestMethod.POST)
    public ResponseEntity<DemandeDto> saveDemande(@RequestBody DemandeDto demande) {
        DemandeDto content = demandeService.createDemande(demande);
        return new ResponseEntity<>(content, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{demandeId}", method = RequestMethod.PUT)
    public ResponseEntity<DemandeDto> updateDemande(@PathVariable String demandeId,
                                                    @RequestBody DemandeDto demande) {
        return ResponseEntity.ok().body(demandeService.updateDemande(UUID.fromString(demandeId), demande));
    }

    @RequestMapping(value = "/demande/{demandeId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDemande(@PathVariable String demandeId) {
        demandeService.deleteDemande(UUID.fromString(demandeId));
        return ResponseEntity.ok().build();
    }
}
