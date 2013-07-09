package br.com.dishup.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Lucas Biccio Ribeiro
 * @version 1.0 Class responsible for represent the restaurant entity
 * @since 10/03/2013
 */
@Entity
@Table(name="restaurante")
@SequenceGenerator(name="id_restaurante_seq", sequenceName="restaurante_id_restaurante_seq", allocationSize=1)
public class RestaurantEntity implements Serializable{
	
	private static final long serialVersionUID = 7574982619759341844L;

	@Id
	@Column(name="id_restaurante")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_restaurante_seq")
	private int id;
	
	@Column(name="CNPJ_numero")
	private String CNPJroot;
	
	@Column(name="CNPJ_filial")
	private String CNPJfilial;
	
	@Column(name="CNPJ_controle")
	private String CNPJcontrol;
	
	@Column(name="razao_social")
	private String socialReason;
	
	@Column(name="site")
	private String site;
	
	@Column(name="DDD_telefone")
	private String DDDtelephone;
	
	@Column(name="telefone")
	private String telephone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inclusao")
	private Date dateInclusion;
	
	@ManyToOne
	@JoinColumn(name="id_status_restaurante")
	private RestaurantStatusEntity status;

	public RestaurantEntity(){
		
	}
	
	public RestaurantEntity(int id, String CNPJroot, String CNPJfilial,
			String CNPJcontrol, String socialReason, String site,
			String dddTelephone, String DDDtelephone, Date dateInclusion,
			RestaurantStatusEntity status) {
		this.id = id;
		this.CNPJroot = CNPJroot;
		this.CNPJfilial = CNPJfilial;
		this.CNPJcontrol = CNPJcontrol;
		this.socialReason = socialReason;
		this.site = site;
		this.DDDtelephone = dddTelephone;
		this.telephone = DDDtelephone;
		this.dateInclusion = dateInclusion;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCNPJroot() {
		return CNPJroot;
	}

	public void setCNPJroot(String CNPJroot) {
		this.CNPJroot = CNPJroot;
	}

	public String getFilial() {
		return CNPJfilial;
	}

	public void setFilial(String CNPJfilial) {
		this.CNPJfilial = CNPJfilial;
	}

	public String getControl() {
		return CNPJcontrol;
	}

	public void setControl(String control) {
		this.CNPJcontrol = control;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDDDTelephone() {
		return DDDtelephone;
	}

	public void setDDDTelephone(String DDDTelephone) {
		this.DDDtelephone = DDDTelephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateInclusion() {
		return dateInclusion;
	}

	public void setDateInclusion(Date dateInclusion) {
		this.dateInclusion = dateInclusion;
	}

	public RestaurantStatusEntity getStatus() {
		return status;
	}

	public void setStatus(RestaurantStatusEntity status) {
		this.status = status;
	}
}