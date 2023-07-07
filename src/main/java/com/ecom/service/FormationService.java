package com.ecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ecom.entity.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecom.configuration.JwtRequestFilter;
import com.ecom.dao.InscriptionRepository;
import com.ecom.dao.FormationRepository;
import com.ecom.dao.UserDao;
import com.ecom.entity.Inscription;
import com.ecom.entity.Formation;
import com.ecom.entity.User;
import com.ecom.dao.FormateurRepository;
@Service
public class FormationService {
	
	@Autowired
	private FormationRepository formationRepository;
	private FormateurRepository formateurRepository;
	@Autowired
	private UserDao userDao;
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	public Formation addNewProduct(Formation formation) {
		return formationRepository.save(formation);
	}
	
	public List<Formation> getAllProducts(int pageNumber, String searchKey){
		Pageable pageable = PageRequest.of(pageNumber, 8);
		
		if(searchKey.equals("")) {
			return (List<Formation>) formationRepository.findAll(pageable);
		}else {
			return (List<Formation>) formationRepository.findByNomFormationContainingIgnoreCaseOrDescriptionFormationContainingIgnoreCase(searchKey, searchKey, pageable);
		}
		
	}
	
	public void deleteProductDetails(Integer idFormation) {
		formationRepository.deleteById(idFormation);
	}

	public Formation getProductDetailsById(Integer idFormation) {
		
		return formationRepository.findById(idFormation).get();
	}


	public List<Formateur> getAllFormateurs(int pageNumber, String searchKey){
		Pageable pageable = PageRequest.of(pageNumber, 8);

		if(searchKey.equals("")) {
			return (List<Formateur>) formateurRepository.findAll(pageable);
		}else {
			return (List<Formateur>) formateurRepository.findByNomFormateurContainingIgnoreCaseOrSpecialiteContainingIgnoreCase(searchKey, searchKey, pageable);
		}

	}


	
	public List<Formation> getProductDetails(boolean isSingeProductCheckout, Integer idFormation) {
	
		if(isSingeProductCheckout && idFormation!= 0) {
			List<Formation> list= new ArrayList<>();
			Formation formation = formationRepository.findById(idFormation).get();
			list.add(formation);
			return list;
		}else {
		
			String username = JwtRequestFilter.CURRENT_USER;
			User user = userDao.findById(username).get();
			List<Inscription> inscriptions = inscriptionRepository.findByUser(user);
			
			return inscriptions.stream().map(x -> x.getProduct()).collect(Collectors.toList());
			
		}
		
	
	}
	
	
	

}
