package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Inscription;
import com.ecom.service.InscriptionService;

@RestController
public class InscriptionController {
	
	@Autowired
	private InscriptionService inscriptionService;
	
	@PreAuthorize("hasRole('User')")
	@GetMapping({"/addToCart/{idFormation}"})
	public Inscription addTocart(@PathVariable(name="idFormation") Integer productId) {
		return inscriptionService.addToCart(productId);
		
	}
	
	@DeleteMapping({"/deleteCartItem/{cartId}"})
	public void deleteCartItem(@PathVariable(name= "cartId") Integer cartId) {
		inscriptionService.deleteCartItem(cartId);
	}
	
	
	
	@PreAuthorize("hasRole('User')")
	@GetMapping({"/getCartDetails"})
	public List<Inscription> getCartDetails() {
		return inscriptionService.getCartDetails();
		
	}




	

}
