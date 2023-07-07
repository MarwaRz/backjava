package com.ecom.service;


import java.util.ArrayList;
import java.util.List;

import com.ecom.dao.*;
import com.ecom.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.configuration.JwtRequestFilter;

@Service
public class CycleService {

    private static final String ORDER_PLACED = "Placed";


    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private InscriptionDetailRepository inscriptionDetailRepository;

    @Autowired
    private FormateurRepository formateurRepository;


    public List<Cycle> getAllCycle() {
        List<Cycle> cycle = new ArrayList<>();
        cycleRepository.findAll().forEach(e -> cycle.add(e));

        return cycle;
    }







}
