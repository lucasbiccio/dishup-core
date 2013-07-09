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
 * Class responsible for encapsulate the object Status.
 * This object represents a code data that indicates a type of system's status for an user, as active, blocked and deleted.
 */
@Entity
@Table(name="status_usuario")
public class UserStatusEntity implements Serializable{
	
	private static final long serialVersionUID = -6761247933433855467L;

	@Id
	@Column(name="id_status_usuario")
	private int id;
	
	@Column(name="nm_status_usuario")
	private String name;
	
	@Column(name="desc_status_usuario")
	private String description;
	
	public UserStatusEntity(){
		
	}

	public UserStatusEntity(int id, String name, String description) {
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
		return "StatusUsuario: idStatusUsuario("+id+") nomeStatusUsuario("+name+") descStatusUsuario("+description+") ";
	}
}