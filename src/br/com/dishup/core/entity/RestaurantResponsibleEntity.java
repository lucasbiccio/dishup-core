package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant responsible entity
 */
@Entity
@Table(name="responsavel_restaurante")
public class RestaurantResponsibleEntity implements Serializable{
	
	private static final long serialVersionUID = -4854449337216468371L;

	@Id
	@OneToOne
	@JoinColumn(name="id_restaurante")
	private RestaurantEntity restaurant;
	
	@Column(name="cpf_numero_responsavel")
	private String CPFroot;
	
	@Column(name="cpf_controle_responsavel")
	private String CPFcontrol;
	
	@Column(name="nm_responsavel")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_cargo_responsavel")
	private EmploymentEntity employment;
	
	@Column(name="ddd_tel_responsavel")
	private String DDDtelephone;
	
	@Column(name="tel_responsavel")
	private String telephone;

	public RestaurantResponsibleEntity(){
		
	}
	
	public RestaurantResponsibleEntity(RestaurantEntity restaurant,
			String CPFroot, String CPFcontrol, String name,
			EmploymentEntity employment, String DDDtelephone, String telephone) {
		this.restaurant = restaurant;
		this.CPFroot = CPFroot;
		this.CPFcontrol = CPFcontrol;
		this.name = name;
		this.employment = employment;
		this.DDDtelephone = DDDtelephone;
		this.telephone = telephone;
	}

	public RestaurantEntity getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantEntity restaurant) {
		this.restaurant = restaurant;
	}

	public String getCPFroot() {
		return CPFroot;
	}

	public void setCPFroot(String CPFroot) {
		this.CPFroot = CPFroot;
	}

	public String getCPFcontrol() {
		return CPFcontrol;
	}

	public void setCPFcontrol(String CPFcontrol) {
		this.CPFcontrol = CPFcontrol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmploymentEntity getEmployment() {
		return employment;
	}

	public void setEmployment(EmploymentEntity employment) {
		this.employment = employment;
	}

	public String getDDDtelephone() {
		return DDDtelephone;
	}

	public void setDDDtelephone(String DDDtelephone) {
		this.DDDtelephone = DDDtelephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}