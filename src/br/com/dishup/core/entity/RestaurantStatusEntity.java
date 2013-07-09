package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant status entity
 */
@Entity
@Table(name="status_restaurante")
public class RestaurantStatusEntity implements Serializable{

	private static final long serialVersionUID = 5242345100728174548L;

	@Id
	@Column(name="id_status_restaurante")
	private int id;
	
	@Column(name="nm_status_restaurante")
	private String name;
	
	@Column(name="desc_status_restaurante")
	private String description;
	
	public RestaurantStatusEntity() {

	}

	public RestaurantStatusEntity(int id, String name, String description){
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "STATUS RESTAURANTE : ID("+id+") NOME("+name+") DESCRICAO("+description+")";
	}
}