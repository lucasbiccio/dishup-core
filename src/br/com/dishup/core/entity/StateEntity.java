package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 21/01/2013
 * @version 1.0 Class responsible for encapsulate the methods of state object (geographic organization)
 */
@Entity
@Table(name="estado")
public class StateEntity implements Serializable{

	private static final long serialVersionUID = -5769035020691666073L;

	@Id
	@Column(name="id_estado")
	private int id;
	
	@Column(name="sigla_estado")
	private String acronym;
	
	@Column(name="nm_estado")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private CountryEntity country;
	
	public StateEntity() {
	}
	
	public StateEntity(int id, String acronym, String name, CountryEntity country) {
		this.id = id;
		this.acronym = acronym;
		this.name = name;
		this.country = country;
	}

	public int getId() {
		return id;
	}
	
	public String getAcronym(){
		return acronym;
	}

	public String getName() {
		return name;
	}

	public CountryEntity getCountry() {
		return country;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ESTADO: ID("+getId()+") SIGLA("+getAcronym()+") NOME("+getName()+") PAIS("+getCountry().toString()+")";
	}
}