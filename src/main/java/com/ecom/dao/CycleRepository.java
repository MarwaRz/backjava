package com.ecom.dao;



import java.util.List;

import com.ecom.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.InscriptionDetail;
import com.ecom.entity.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Integer> {



}
