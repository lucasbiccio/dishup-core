package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant user group entity. 
 */
@Entity
@Table(name="grupo_usuario_restaurante")
public class RestaurantUserGroupEntity implements Serializable{
	
	private static final long serialVersionUID = -1338286897507744517L;

	@Id
	@OneToOne
	@JoinColumn(name="id_restaurante")
	private RestaurantEntity restaurant;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_usuario_restaurante")
	private UserRestaurantEntity user;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private UserTypeEntity userType;

	public RestaurantUserGroupEntity(){
		
	}

	public RestaurantUserGroupEntity(RestaurantEntity restaurant,
			UserRestaurantEntity user, UserTypeEntity userType) {
		this.restaurant = restaurant;
		this.user = user;
		this.userType = userType;
	}

	public RestaurantEntity getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantEntity restaurant) {
		this.restaurant = restaurant;
	}

	public UserRestaurantEntity getUser() {
		return user;
	}

	public void setUser(UserRestaurantEntity user) {
		this.user = user;
	}

	public UserTypeEntity getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEntity userType) {
		this.userType = userType;
	}
}