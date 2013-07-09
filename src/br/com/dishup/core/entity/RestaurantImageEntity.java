package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant image entity
 */
@Entity
@Table(name="imagem_restaurante")
public class RestaurantImageEntity implements Serializable{

	private static final long serialVersionUID = -5937327801010107989L;

	@Id
	@OneToOne
	@JoinColumn(name="id_restaurante")
	private RestaurantEntity restaurant;
	
	@Id
	@Column(name="id_imagem")
	private int idImage;
	
	@Column(name="url_imagem")
	private String URLimage;
	
	public RestaurantImageEntity(){
		
	}

	public RestaurantImageEntity(RestaurantEntity restaurant, int idImage, String URLimage) {
		this.restaurant = restaurant;
		this.idImage = idImage;
		this.URLimage = URLimage;
	}

	public RestaurantEntity getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantEntity restaurant) {
		this.restaurant = restaurant;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getURLimage() {
		return URLimage;
	}

	public void setURLimage(String URLimage) {
		this.URLimage = URLimage;
	}
}