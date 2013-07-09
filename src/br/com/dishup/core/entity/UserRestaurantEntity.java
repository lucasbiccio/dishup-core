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
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant user entity
 */
@Entity
@Table(name="usuario_restaurante")
@SequenceGenerator(name="id_usuario_restaurante_seq", sequenceName="usuario_restaurante_id_usuario_restaurante_seq", allocationSize=1)
public class UserRestaurantEntity implements Serializable {

	private static final long serialVersionUID = -4850946546553569528L;

	@Id
	@Column(name="id_usuario_restaurante")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_usuario_restaurante_seq")
	private int id;
	
	@Column(name="email_usuario_restaurante")
	private String email;
	
	@Column(name="assinatura_usuario_restaurante")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="id_status_usuario_restaurante")
	private UserStatusEntity status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inclusao_usuario_restaurante")
	private Date dateInclusion;

	public UserRestaurantEntity(){
		
	}
	
	public UserRestaurantEntity(int id, String email, String password,
			UserStatusEntity status, Date dateInclusion) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
		this.dateInclusion = dateInclusion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatusEntity getStatus() {
		return status;
	}

	public void setStatus(UserStatusEntity status) {
		this.status = status;
	}

	public Date getDateInclusion() {
		return dateInclusion;
	}

	public void setDateInclusion(Date dateInclusion) {
		this.dateInclusion = dateInclusion;
	}
}