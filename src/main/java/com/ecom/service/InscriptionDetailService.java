package com.ecom.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.configuration.JwtRequestFilter;
import com.ecom.dao.InscriptionRepository;
import com.ecom.dao.InscriptionDetailRepository;
import com.ecom.dao.FormationRepository;
import com.ecom.dao.UserDao;
import com.ecom.entity.Inscription;
import com.ecom.entity.InscriptionDetail;
import com.ecom.entity.Input;
import com.ecom.entity.NbFormation;
import com.ecom.entity.Formation;
import com.ecom.entity.User;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sound.midi.MidiFileFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class InscriptionDetailService {
	
	private static final String ORDER_PLACED = "Placed";  
	
	@Autowired
	private InscriptionDetailRepository inscriptionDetailRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	Formation formation;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	public List<InscriptionDetail> getAllOrderDetails(){
		List<InscriptionDetail> inscriptionDetails = new ArrayList<>();
		inscriptionDetailRepository.findAll().forEach(e -> inscriptionDetails.add(e));
		
		return inscriptionDetails;
	}
	
	public List<InscriptionDetail> getOrderDetails() {
		String currentUser = JwtRequestFilter.CURRENT_USER;
		User user = userDao.findById(currentUser).get();
		return inscriptionDetailRepository.findByUser(user);
	}

	public List<InscriptionDetail> getOrderDetailsFormation(int pageNumber, String searchKey) {
		Pageable pageable = PageRequest.of(pageNumber, 8);
		if(searchKey.equals("")) {
			return (List<InscriptionDetail>) inscriptionDetailRepository.findAll();
		}else
		return inscriptionDetailRepository.findByFormation(formation);
	}







	
	public void placeOrder(Input input, boolean isSingleProductCheckout) {
		List<NbFormation> productQuantityList = input.getOrderProductQuantityList();
		
		for(NbFormation o: productQuantityList) {
			Formation formation = formationRepository.findById(o.getIdFormation()).get();
			
			String currentUser = JwtRequestFilter.CURRENT_USER;
			User user= userDao.findById(currentUser).get();
			
			InscriptionDetail inscriptionDetail = new InscriptionDetail(
					input.getFullName(),
					input.getFullAddress(),
					input.getContactNumber(),
					input.getAlternateContactNumber(),
					ORDER_PLACED,
					formation.getProductDiscountedPrice()*o.getQuantity(),
					formation,
					user);
			
			if(!isSingleProductCheckout) {
				List<Inscription> inscriptions = inscriptionRepository.findByUser(user);
				inscriptions.stream().forEach(x -> inscriptionRepository.deleteById(x.getCartId()));
				
			}
			inscriptionDetailRepository.save(inscriptionDetail);
		}
	}



	

}
