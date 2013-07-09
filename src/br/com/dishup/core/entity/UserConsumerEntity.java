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
 * @version 1.0 Class responsible for represent user s consumer entity
 */
@Entity
@Table(name="usuario_consumidor")
@SequenceGenerator(name="id_usuario_consumidor_seq", sequenceName="usuario_consumidor_id_usuario_consumidor_seq", allocationSize=1)
public class UserConsumerEntity implements Serializable{
	
	private static final long serialVersionUID = 5335586099296882402L;

	@Id
	@Column(name="id_usuario_consumidor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_usuario_consumidor_seq")
	private int id;
	
	@Column(name="email_usuario_consumidor")
	private String email;
	
	@Column(name="assinatura_usuario_consumidor")
	private String pasword;
	
	@ManyToOne
	@JoinColumn(name="id_status_usuario_consumidor")
	private UserStatusEntity status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inclusao_usuario_consumidor")
	private Date dateInclusion;
	
	public UserConsumerEntity(){
		
	}
	
	public UserConsumerEntity(int id, String email, String password,
			UserStatusEntity status, Date dateInclusion) {
		this.id = id;
		this.email = email;
		this.pasword = password;
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
		return pasword;
	}

	public void setPassword(String password) {
		this.pasword = password;
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