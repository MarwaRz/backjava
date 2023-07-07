package com.ecom.dao;


import com.ecom.entity.Formation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Formateur;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Integer>{


    public List<Formateur> findByNomFormateurContainingIgnoreCaseOrSpecialiteContainingIgnoreCase(
            String key1, String key2, Pageable pageable);


    public List<Formateur>findByNomFormateur(String nomFormateur);
}

