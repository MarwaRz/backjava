package com.ecom.controller;

import com.ecom.dao.CycleRepository;
import com.ecom.entity.Cycle;
import com.ecom.entity.Formateur;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CycleController {


    CycleRepository cycleRepository;

    @GetMapping("/cycle")
    public List<Cycle> getAllCycle()
    {
        return cycleRepository.findAll();
    }

    @PostMapping("/cycle")
    public Cycle createcycle(@Valid @RequestBody Cycle cycle) {
        return cycleRepository.save(cycle);
    }




}
