package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @version 1.0 Class responsible for encapsulate the country object
 * @since 24/03/2014
 */
@Entity
@Table(name="pais")
public class CountryEntity implements Serializable{
	
	private static final long serialVersionUID = -120672092844746862L;
	
	@Id
	@Column(name="id_pais")
	private int id;
	
	@Column(name="sigla_pais")
	private String acronym;
	
	@Column(name="nm_pais")
	private String name;
	
	public CountryEntity() {
	}
	
	public CountryEntity(int id, String acronym, String name) {
		this.id = id;
		this.acronym = acronym;
		this.name = name;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PAIS: ID("+getId()+") SIGLA("+getAcronym()+") NOME("+getName()+")";
	}	
}