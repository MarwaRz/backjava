package com.ecom.dao;

import java.util.List;

import com.ecom.entity.Formation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.InscriptionDetail;
import com.ecom.entity.User;

@Repository
public interface InscriptionDetailRepository extends CrudRepository<InscriptionDetail, Integer>{
	
	public List<InscriptionDetail> findByUser(User user);
	public List<InscriptionDetail> findByFormation(Formation formation);

}
