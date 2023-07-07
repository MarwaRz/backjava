package com.ecom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Inscription;
import com.ecom.entity.User;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Integer>{
	
	public List<Inscription> findByUser(User user);

}
