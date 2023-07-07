package com.ecom.controller;



import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.ecom.entity.Formation;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ecom.service.FormationService;
import com.ecom.controller.ResourceNotFoundException;
import com.ecom.entity.Formateur;
import com.ecom.dao.FormateurRepository;


@RestController

public class FormateurController {
    @Autowired
    private FormateurRepository formateurRepository;
    private FormationService formationService;

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/formateur")
    public List<Formateur> getAllFormateur() {

        return formateurRepository.findAll();
    }
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/formateur/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable(value = "id") Integer formateurId)
            throws ResourceNotFoundException {
        Formateur formateur = formateurRepository.findById(formateurId)
                .orElseThrow(() -> new ResourceNotFoundException("formateur n exiqte pas :: " + formateurId));
        return ResponseEntity.ok().body(formateur);
    }
    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/formateur")
    public Formateur createFormateur(@Valid @RequestBody Formateur formateur) {
        return formateurRepository.save(formateur);
    }
    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/formateur/{id}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable(value = "id") Integer formateurId,
                                                   @Valid @RequestBody Formateur formateurDetails) throws ResourceNotFoundException {
        Formateur formateur = formateurRepository.findById(formateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + formateurId));

        formateur.setNomFormateur(formateurDetails.getNomFormateur());
        formateur.setSpecialite(formateurDetails.getSpecialite());
        formateur.setDirection(formateurDetails.getDirection());
        final Formateur updatedEmployee = formateurRepository.save(formateur);
        return ResponseEntity.ok(updatedEmployee);
    }




    @GetMapping({"/getAllFormateurs"})
    public List<Formateur> getAllFormateurs(@RequestParam(defaultValue = "0") int pageNumber
            , @RequestParam(defaultValue = "") String searchKey){
        return formationService.getAllFormateurs(pageNumber, searchKey);
    }




    @DeleteMapping("/formateur/{id}")
    public Map<String, Boolean> deleteFormateur(@PathVariable(value = "id") Integer formateurId)
            throws ResourceNotFoundException {
        Formateur formateur = formateurRepository.findById(formateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Formateur n existe pas :: " + formateurId));

        formateurRepository.delete(formateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
