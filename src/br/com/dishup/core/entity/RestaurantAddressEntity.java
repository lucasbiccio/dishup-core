package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant address entity
 */
@Entity
@Table(name="endereco_restaurante")
public class RestaurantAddressEntity implements Serializable{
	
	private static final long serialVersionUID = -3358410266125985631L;

	@Id
	@OneToOne
	@JoinColumn(name="id_restaurante")
	private RestaurantEntity restaurant;
	
	@Column(name="CEP_prefixo")
	private String CEPprefix;
	
	@Column(name="CEP_sulfixo")
	private String CEPsuffix;
	
	@Column(name="logradouro")
	private String address;
	
	@Column(name="numero")
	private String number;
	
	@Column(name="bairro")
	private String neighborhood;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private CountryEntity country;
	
	@ManyToOne
	@JoinColumn(name="id_estado")
	private StateEntity state;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private CityEntity city;

	public RestaurantAddressEntity() {
	
	}

	public RestaurantAddressEntity(RestaurantEntity restaurant, String CEPprefix, String CEPsuffix, 
			String address, String number, String neighborhood, CountryEntity country, 
			StateEntity state,CityEntity city) {
		this.restaurant = restaurant;
		this.CEPprefix = CEPprefix;
		this.CEPsuffix = CEPsuffix;
		this.address = address;
		this.number = number;
		this.neighborhood = neighborhood;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	public RestaurantEntity getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantEntity restaurant) {
		this.restaurant = restaurant;
	}

	public String getCEPprefix() {
		return CEPprefix;
	}

	public void setCEPprefix(String CEPprefix) {
		this.CEPprefix = CEPprefix;
	}

	public String getCEPsuffix() {
		return CEPsuffix;
	}

	public void setCEPsuffix(String CEPsuffix) {
		this.CEPsuffix = CEPsuffix;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public StateEntity getState() {
		return state;
	}

	public void setEstado(StateEntity state) {
		this.state = state;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}
}