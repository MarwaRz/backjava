package com.ecom.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Formation {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFormation;
	private String nomFormation;
	@Column(length = 1000)
	private String descriptionFormation;
	private Double productDiscountedPrice;
	private String a;

	@ManyToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL)
	@JoinTable(name = "product_images",
			joinColumns = {
					@JoinColumn(name = "product_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "image_id")
			})
	private Set<ImageModel> productImages;



	public Set<ImageModel> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer productId) {
		this.idFormation = productId;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String productName) {
		this.nomFormation = productName;
	}

	public String getDescriptionFormation() {
		return descriptionFormation;
	}

	public void setDescriptionFormation(String productDescription) {
		this.descriptionFormation = productDescription;
	}

	public Double getProductDiscountedPrice() {
		return productDiscountedPrice;
	}

	public void setProductDiscountedPrice(Double productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public Formation(Integer idFormation, String nomFormation, String descriptionFormation, Double productDiscountedPrice,
					 String a) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormation;
		this.descriptionFormation = descriptionFormation;
		this.productDiscountedPrice = productDiscountedPrice;
		this.a = a;
	}

}
	
	
	
	

