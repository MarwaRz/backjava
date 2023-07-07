package com.ecom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Inscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@OneToOne
	private Formation formation;
	@OneToOne
	private User user;
	
	
	
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Inscription(Formation formation, User user) {
		super();
		this.formation = formation;
		this.user = user;
	}


	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Formation getProduct() {
		return formation;
	}
	public void setProduct(Formation formation) {
		this.formation = formation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
