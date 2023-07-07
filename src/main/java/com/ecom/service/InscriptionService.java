package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.configuration.JwtRequestFilter;
import com.ecom.dao.InscriptionRepository;
import com.ecom.dao.FormationRepository;
import com.ecom.dao.UserDao;
import com.ecom.entity.Inscription;
import com.ecom.entity.Formation;
import com.ecom.entity.User;

@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private UserDao userDao;
	
	public void deleteCartItem(Integer cartId) {
		inscriptionRepository.deleteById(cartId);
	}
	
	public Inscription addToCart(Integer idFormation) {
		
		Formation formation = formationRepository.findById(idFormation).get();
		
		String username = JwtRequestFilter.CURRENT_USER;
		
		User user = null;
		
		if(username != null) {
			user = userDao.findById(username).get();
			
		}
		
		List<Inscription> inscriptionList = inscriptionRepository.findByUser(user);
		List<Inscription> filteredList = inscriptionList.stream().filter(x -> x.getProduct().getIdFormation() == idFormation).collect(Collectors.toList());
		
		if(filteredList.size() > 0) {
			return null;
		}
		
		
		if(formation != null && user != null) {
			Inscription inscription = new Inscription(formation, user);
			return inscriptionRepository.save(inscription);
		}
		return null;
	}
	
	public List<Inscription> getCartDetails(){
		String username = JwtRequestFilter.CURRENT_USER;
		User user = userDao.findById(username).get();
		return inscriptionRepository.findByUser(user);
		
	}
	
	

}
