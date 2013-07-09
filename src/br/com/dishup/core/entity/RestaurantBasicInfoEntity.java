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
 * @version 1.0 Class responsible for represent the restaurant basic info entity
 */
@Entity
@Table(name="dado_basico_restaurante")
public class RestaurantBasicInfoEntity implements Serializable {
	
	private static final long serialVersionUID = -7836306766897403605L;

	@Id
	@OneToOne
	@JoinColumn(name="id_restaurante")
	private RestaurantEntity restaurant;
	
	@Column(name="url_logo")
	private String URLlogo;
	
	@Column(name="desc_resumida")
	private String resumeDescription;
	
	@Column(name="desc_completa")
	private String completeDescription;
	
	@JoinColumn(name="id_tipo_culinaria")
	private CulinaryTypeEntity culinaryType;
	
	public RestaurantBasicInfoEntity(){
		
	}

	public RestaurantBasicInfoEntity(RestaurantEntity restaurant, String URLlogo, 
			String resumeDescription, String completeDescription, CulinaryTypeEntity culinaryType) {
		this.restaurant = restaurant;
		this.URLlogo = URLlogo;
		this.resumeDescription = resumeDescription;
		this.completeDescription = completeDescription;
		this.culinaryType = culinaryType;
	}

	public RestaurantEntity getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantEntity restaurant) {
		this.restaurant = restaurant;
	}

	public String getURLlogo() {
		return URLlogo;
	}

	public void setURLlogo(String URLlogo) {
		this.URLlogo = URLlogo;
	}

	public String getResumeDescription() {
		return resumeDescription;
	}

	public void setResumeDescription(String resumeDescription) {
		this.resumeDescription = resumeDescription;
	}

	public String getCompleteDescription() {
		return completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		this.completeDescription = completeDescription;
	}

	public CulinaryTypeEntity getCulinaryType() {
		return culinaryType;
	}

	public void setCulinaryType(CulinaryTypeEntity culinaryType) {
		this.culinaryType = culinaryType;
	}
}