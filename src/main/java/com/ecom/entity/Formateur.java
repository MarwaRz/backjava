package com.ecom.entity;


import javax.persistence.*;


@Entity
@Table(name= "formateur")
public class Formateur {

	private Integer id;
	private String nomFormateur;
	private String specialite;
	private String direction;
	
	public Formateur() {
		
	}
	
	public Formateur(String nomFormateur, String specialite, String direction) {
		this.nomFormateur = nomFormateur;
		this.specialite = specialite;
		this.direction = direction;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getNomFormateur() {
		return nomFormateur;
	}
	public void setNomFormateur(String firstName) {
		this.nomFormateur = firstName;
	}
	

	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String lastName) {
		this.specialite = lastName;
	}
	

	public String getDirection() {
		return direction;
	}
	public void setDirection(String emailId) {
		this.direction = emailId;
	}

	
}
