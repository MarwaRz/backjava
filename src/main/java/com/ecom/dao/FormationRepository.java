package com.ecom.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Formation;

@Repository
public interface FormationRepository extends CrudRepository<Formation, Integer>{

	public List<Formation> findAll(Pageable pageable);
	
	public List<Formation>  findByNomFormationContainingIgnoreCaseOrDescriptionFormationContainingIgnoreCase(
			String key1, String key2, Pageable pageable);


}
