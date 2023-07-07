package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ecom.entity.InscriptionDetail;
import com.ecom.entity.Input;
import com.ecom.service.InscriptionDetailService;

@RestController
public class InscriptionDetailController {
	
	@Autowired
	private InscriptionDetailService inscriptionDetailService;
	
	
	
	@PreAuthorize("hasRole('User')")
	@PostMapping({"/placeOrder/{isSingleProductCheckout}"})
	public void placeOrder(@PathVariable(name= "isSingleProductCheckout") boolean isSingleProductCheckout, @RequestBody Input input) {
		inscriptionDetailService.placeOrder(input, isSingleProductCheckout);
		
	}
	
	@PreAuthorize("hasRole('User')")
	@GetMapping({"/getOrderDetails"})
	public List<InscriptionDetail> getOrderDetails() {
		return inscriptionDetailService.getOrderDetails();
	}
	
	@PreAuthorize("hasRole('Admin')")
	@GetMapping({"/getAllOrderDetails"})
	public List<InscriptionDetail> getAllOrderDetails() {
		return inscriptionDetailService.getAllOrderDetails();
	}



@PreAuthorize("hasRole('Admin')")
@GetMapping({"/getAllOrderDetailsFormation"})

public List<InscriptionDetail> getOrderDetailsFormation(@RequestParam(defaultValue = "0") int pageNumber
		, @RequestParam(defaultValue = "") String searchKey) {
		return inscriptionDetailService.getOrderDetailsFormation( pageNumber, searchKey);
		}

		}
