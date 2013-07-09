package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @version 1.0 Class responsible for encapsulate the city object
 * @author Lucas Biccio Ribeiro
 * @since 21/01/2013
 */
@Entity
@Table(name="cidade")
public class CityEntity implements Serializable{
	
	private static final long serialVersionUID = -8398266876369999146L;

	@Id
	@Column(name="id_cidade")
	private int id;
	
	@Column(name="nm_cidade")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private StateEntity state;
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	private CountryEntity country;
	
	public CityEntity() {
	}
	
	public CityEntity(int id, String name, StateEntity state, CountryEntity country) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public StateEntity getState() {
		return state;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CIDADE: ID("+getId()+") NOME("+getName()+") ESTADO("+getState().toString()+") PAIS("+getCountry().toString()+")";
	}
}