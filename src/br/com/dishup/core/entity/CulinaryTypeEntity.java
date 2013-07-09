package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the culinary type entity.
 */
@Entity
@Table(name="tipo_culinaria")
public class CulinaryTypeEntity implements Serializable{
	
	private static final long serialVersionUID = -4887983414385074350L;

	@Id
	@Column(name="id_tipo_culinaria")
	private int id;
	
	@Column(name="nm_tipo_culinaria")
	private String name;
	
	@Column(name="desc_tipo_culinaria")
	private String description;
	
	public CulinaryTypeEntity() {
		
	}

	public CulinaryTypeEntity(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TIPO CULINARIA: ID("+id+") NOME("+name+") DESCRICAO("+description+")";
	}
}