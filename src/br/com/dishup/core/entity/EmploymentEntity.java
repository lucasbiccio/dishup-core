package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since  24/04/2013
 * @version 1.0
 * Class responsible for encapsulate the employment representation entity
 */
@Entity
@Table(name="cargo")
public class EmploymentEntity implements Serializable{
	
	private static final long serialVersionUID = 8833543976192216315L;

	@Id
	@Column(name="id_cargo")
	private int id;
	
	@Column(name="nm_cargo")
	private String name;
	
	@Column(name="desc_cargo")
	private String description;
	
	public EmploymentEntity(){
		
	}
	
	public EmploymentEntity(int id, String name, String description) {
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

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CARGO: ID("+id+") NOME("+name+") DESCRICAO("+description+")";
	}
}