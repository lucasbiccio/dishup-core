package br.com.dishup.core.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 24/03/2013
 * @version 1.0
 * Class responsible for encapsulate the proposal status object
 */
@Entity
@Table(name="status_proposta")
public class ProposalStatusEntity implements Serializable{

	private static final long serialVersionUID = 5096859216865376576L;

	@Id
	@Column(name="id_status_proposta")
	private int id;
	
	@Column(name="nm_status_proposta")
	private String name;
	
	@Column(name="desc_status_proposta")
	private String description;

	public ProposalStatusEntity(){
		
	}
	
	public ProposalStatusEntity(int id, String name, String description) {
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
	
	public String getDescription(){
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
		return "STATUS PROPOSTA: ID("+id+") NOME("+name+") DESCRICAO("+description+")";
	}
}