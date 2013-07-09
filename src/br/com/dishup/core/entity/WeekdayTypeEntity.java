package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the weekday type entity.
 */
@Entity
@Table(name="tipo_dia_semana")
public class WeekdayTypeEntity implements Serializable{

	private static final long serialVersionUID = -7708781342671735638L;

	@Id
	@Column(name="id_tipo_dia_semana")
	private int id;
	
	@Column(name="nm_tipo_dia_semana")
	private String name;

	public WeekdayTypeEntity(){
		
	}
	
	public WeekdayTypeEntity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "TIPO DIA SEMANA: ID("+id+") NOME("+name+")";
	}
}