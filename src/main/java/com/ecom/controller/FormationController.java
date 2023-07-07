package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Formation;
import com.ecom.service.FormationService;

@RestController
public class FormationController {
	
	@Autowired
	private FormationService formationService;
	
	@PreAuthorize("hasRole('Admin')")
	@PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Formation addNewProduct(@RequestPart("product") Formation formation) {
	
		try {


			return formationService.addNewProduct(formation);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	/*
	
	public Set<ImageModel> uplodImage(MultipartFile[] multipartFiles) throws IOException{
		
		Set<ImageModel> imageModels = new HashSet<>();
		
		for(MultipartFile file: multipartFiles) {
			ImageModel imageModel = new ImageModel(
					file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes());
			imageModels.add(imageModel);
		}
		return imageModels;
	}
	*/
	
	@GetMapping({"/getAllProducts"})
	public List<Formation> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber
			, @RequestParam(defaultValue = "") String searchKey){
		return formationService.getAllProducts(pageNumber, searchKey);
	}
	
	
	@GetMapping({"/getProductDetailsById/{idFormation}"})
	public Formation getProductDetailsById(@PathVariable("idFormation") Integer idFormation) {
		
		return formationService.getProductDetailsById(idFormation);
		
	}
	
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping({"/deleteProductDetails/{idFormation}"})
	public void deleteProductDetailes(@PathVariable("idFormation") Integer idFormation) {
		formationService.deleteProductDetails(idFormation);
	}
	
	@PreAuthorize("hasRole('User')")
	@GetMapping({"/getProductDetails/{isSingeProductCheckout}/{idFormation}"})
	public List<Formation> getProductDetails(@PathVariable(name="isSingeProductCheckout") boolean isSingeProductCheckout,
											 @PathVariable(name= "idFormation") Integer idFormation  ) {
		
		return formationService.getProductDetails(isSingeProductCheckout,idFormation);
		
		
	}

}
