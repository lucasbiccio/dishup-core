package br.com.dishup.core.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 06/02/2013
 * @version 1.0
 * Class responsible for encapsulate the object TipoUsuario.
 * This object represents a code data that indicates a type of system's user, as Consumidor or a Restaurante.
 */
@Entity
@Table(name="tipo_usuario")
public class UserTypeEntity implements Serializable{
	
	private static final long serialVersionUID = 7027334718139252704L;

	@Id
	@Column(name="id_tipo_usuario")
	private int id;
	
	@Column(name="nm_tipo_usuario")
	private String name;
	
	@Column(name="desc_tipo_usuario")
	private String description;
	
	public UserTypeEntity(){
		
	}
	
	public UserTypeEntity(int id, String name, String description) {
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

	public void setNome(String nome) {
		this.name = nome;
	}

	public void setDescricao(String descricao) {
		this.description = descricao;
	}

	@Override
	public String toString() {
		return "TipoUsuario: idTipoUsuario("+this.id+") nomeTipoUsuario("+this.name+") descTipoUsuario("+this.description+")";
	}
}