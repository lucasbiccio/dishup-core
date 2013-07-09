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
 * @version 1.0 Class responsible for represent the restaurant s proposal entity.
 */
@Entity
@Table(name="proposta_restaurante")
@SequenceGenerator(name="id_proposta_seq", sequenceName="proposta_restaurante_id_proposta_seq", allocationSize=1)
public class RestaurantProposalEntity implements Serializable {

	private static final long serialVersionUID = 1443357949571437587L;

	@Id
	@Column(name="id_proposta")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_proposta_seq")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inclusao")
	private Date dateInclusion;
	
	@ManyToOne
	@JoinColumn(name="id_status_proposta")
	private ProposalStatusEntity status;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_aprovacao")
	private UserAdministratorEntity userAproover;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_avaliacao")
	private Date dateAproove;
	
	@Column(name="email_restaurante")
	private String email;
	
	@Column(name="cnpj_numero")
	private String CNPJroot;
	
	@Column(name="cnpj_filial")
	private String CNPJfilial;
	
	@Column(name="cnpj_controle")
	private String CNPJcontrol
	;
	
	@Column(name="razao_social_restaurante")
	private String socialReason;
	
	@Column(name="cep_restaurante")
	private String CEP;
	
	@Column(name="logradouro_restaurante")
	private String address;
	
	@Column(name="num_restaurante")
	private String addressNumber;
	
	@Column(name="compl_restaurante")
	private String addressComplement;
	
	@Column(name="bairro_restaurante")
	private String neighborhood;
	
	@ManyToOne
	@JoinColumn(name="id_cidade_restaurante")
	private CityEntity city;
	
	@ManyToOne
	@JoinColumn(name="id_estado_restaurante")
	private StateEntity state;
	
	@ManyToOne
	@JoinColumn(name="id_pais_restaurante")
	private CountryEntity country;
	
	@Column(name="ddd_tel_comecial_restaurante")
	private String DDDtelephone;
	
	@Column(name="tel_comecial_restaurante")
	private String telephone;
	
	@Column(name="site_restaurante")
	private String site;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_culinaria")
	private CulinaryTypeEntity culinaryType;
	
	@Column(name="cpf_numero_contato")
	private String CPFroot;
	
	@Column(name="cpf_controle_contato")
	private String CPFcontrol;
	
	@Column(name="nm_contato")
	private String responsibleName;
	
	@ManyToOne
	@JoinColumn(name="id_cargo_contato")
	private EmploymentEntity responsibleEmployment;
	
	@Column(name="ddd_tel_contato")
	private String responsibleDDDtelephone;
	
	@Column(name="tel_contato")
	private String responsibleTelephone;

	public RestaurantProposalEntity(){
		
	}
	
	public RestaurantProposalEntity(int id, Date dateInclusion,ProposalStatusEntity status,
			UserAdministratorEntity userAproover, Date dateAproove,String email, String CNPJroot, 
			String CNPJfilial,String CNPJcontrol, String socialReason, String CEP, String address, 
			String addressNumber,String addressComplement, String neighborhood, CityEntity city,
			StateEntity state, CountryEntity country,String DDDtelephone, String telephone,
			String site, CulinaryTypeEntity culinaryType, String CPFroot, String CPFcontrol,
			String responsibleName, EmploymentEntity responsibleEmployment, String responsibleDDDtelephone, 
			String responsibleTelephone) {
		this.id = id;
		this.dateInclusion = dateInclusion;
		this.status = status;
		this.userAproover = userAproover;
		this.dateAproove = dateAproove;
		this.email = email;
		this.CNPJroot = CNPJroot;
		this.CNPJfilial = CNPJfilial;
		this.CNPJcontrol = CNPJcontrol;
		this.socialReason = socialReason;
		this.CEP = CEP;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.DDDtelephone = DDDtelephone;
		this.telephone = telephone;
		this.site = site;
		this.culinaryType = culinaryType;
		this.CPFroot = CPFroot;
		this.CPFcontrol = CPFcontrol;
		this.responsibleName = responsibleName;
		this.responsibleEmployment = responsibleEmployment;
		this.responsibleDDDtelephone = responsibleDDDtelephone;
		this.responsibleTelephone = responsibleTelephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateInclusion() {
		return dateInclusion;
	}

	public void setDateInclusion(Date dateInclusion) {
		this.dateInclusion = dateInclusion;
	}

	public ProposalStatusEntity getStatus() {
		return status;
	}

	public void setStatus(ProposalStatusEntity status) {
		this.status = status;
	}

	public UserAdministratorEntity getUserAproover() {
		return userAproover;
	}

	public void setUserAproover(UserAdministratorEntity userAproover) {
		this.userAproover = userAproover;
	}

	public Date getDateAproove() {
		return dateAproove;
	}

	public void setDateAproove(Date dateAproove) {
		this.dateAproove = dateAproove;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCNPJroot() {
		return CNPJroot;
	}

	public void setCNPJroot(String CNPJroot) {
		this.CNPJroot = CNPJroot;
	}

	public String getCNPJfilial() {
		return CNPJfilial;
	}

	public void setCNPJfilial(String CNPJfilial) {
		this.CNPJfilial = CNPJfilial;
	}

	public String getCNPJcontrol() {
		return CNPJcontrol;
	}

	public void setCNPJcontrol(String CNPJcontrol) {
		this.CNPJcontrol = CNPJcontrol;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public CulinaryTypeEntity getCulinaryType() {
		return culinaryType;
	}

	public void setCulinaryType(CulinaryTypeEntity culinaryType) {
		this.culinaryType = culinaryType;
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

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public EmploymentEntity getResponsibleEmployment() {
		return responsibleEmployment;
	}

	public void setResponsibleEmployment(EmploymentEntity responsibleEmployment) {
		this.responsibleEmployment = responsibleEmployment;
	}

	public String getResponsibleDDDtelephone() {
		return responsibleDDDtelephone;
	}

	public void setResponsibleDDDtelephone(String responsibleDDDtelephone) {
		this.responsibleDDDtelephone = responsibleDDDtelephone;
	}

	public String getResponsibleTelephone() {
		return responsibleTelephone;
	}

	public void setResponsibleTelephone(String responsibleTelephone) {
		this.responsibleTelephone = responsibleTelephone;
	}
}