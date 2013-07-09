package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Session;

import br.com.dishup.core.codedata.ProposalStatusCD;
import br.com.dishup.core.entity.RestaurantProposalEntity;
import br.com.dishup.core.exception.ProposalNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/07/2013
 * @version 1.0 Class responsible for encapsulate the restaurant proposal data access object
 */
public class RestaurantProposalDAO {

	/**
	 * Method responsible to insert the proposal into database
	 * @param session database connection
	 * @param proposal object
	 */
	public void insert(Session session, RestaurantProposalEntity proposal){
		session.save(proposal);
	}
	
	/**
	 * Method responsible to update the proposal into database
	 * @param session database connection
	 * @param proposal object
	 */
	public void update(Session session, RestaurantProposalEntity proposal){
		session.update(proposal);
	}
	
	/**
	 * Method responsible for select a specific proposal by its id
	 * @param session database connection
	 * @param id proposal
	 * @return proposal object
	 * @throws ProposalNotFoundException when there is no proposal found to this id 
	 */
	public RestaurantProposalEntity selectById(Session session, int id) throws ProposalNotFoundException{
		String hql = "FROM RestaurantProposalEntity WHERE id_proposta = :id";
		RestaurantProposalEntity proposal = (RestaurantProposalEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(proposal == null) throw new ProposalNotFoundException("PROPOSAL NOT FOUND - ID: "+id);
		else return proposal;
	}
	
	/**
	 * Method responsible to return a list of proposal with a specific restaurant CNPJ
	 * @param session database connection
	 * @param CNPJroot cnpj root
	 * @param CNPJfilial cpjn filial
	 * @param CNPJcontrol cnpj control
	 * @return list of proposal
	 * @throws ProposalNotFoundException when there is no proposal with that cpnj
	 */
	public List<RestaurantProposalEntity> selectByCNPJ(Session session, String CNPJroot, String CNPJfilial, String CNPJcontrol) throws ProposalNotFoundException{
		String hql = "FROM RestaurantProposalEntity WHERE cnpj_numero = :root and cnpj_filial = :filial and cnpj_controle = :control";
		@SuppressWarnings("unchecked")
		List<RestaurantProposalEntity> proposal = (List<RestaurantProposalEntity>) session.createQuery(hql).
				setString("root", CNPJroot).
				setString("filial", CNPJfilial).
				setString("control", CNPJcontrol).
				list();
		if(proposal.isEmpty()) throw new ProposalNotFoundException("PROPOSAL NOT FOUND - CNPJ: "+CNPJroot+"/"+CNPJfilial+"/"+CNPJcontrol);
		else return proposal;
	}
	
	/**
	 * Method responsible to return a list of proposal with a specific status
	 * @param session connection database
	 * @param idStatus proposal id status
	 * @return list of proposal
	 * @throws ProposalNotFoundException when no register is found to the status informed
	 */
	public List<RestaurantProposalEntity> selectByStatus(Session session, int idStatus) throws ProposalNotFoundException{
		String hql = "FROM RestaurantProposalEntity WHERE id_status_proposta = :idStatus";
		@SuppressWarnings("unchecked")
		List<RestaurantProposalEntity> list = session.createQuery(hql).setInteger("idStatus", idStatus).list();
		if(list.isEmpty()) throw new ProposalNotFoundException("NO RESULTS FOUND TO THIS QUERY");
		else return list;
	}
	
	/**
	 * Method responsible to verify if there is a proposal with pending status by a specific cnpj 
	 * @param session database connection
	 * @param CNPJroot cnpj root
	 * @param CNPJfilial cnpj filial
	 * @param CNPJcontrol cnpj control
	 * @return true if there is some proposal or false if there no proposal
	 */
	public boolean hasPropostaPendente(Session session, String CNPJroot, String CNPJfilial, String CNPJcontrol){
		String hql = "FROM RestaurantProposalEntity WHERE cnpj_numero = :root and cnpj_filial = :filial and cnpj_controle = :control and id_status_proposta = :idStatus";
		@SuppressWarnings("unchecked")
		List<RestaurantProposalEntity> list = (List<RestaurantProposalEntity>) session.createQuery(hql).
				setString("root", CNPJroot).
				setString("filial", CNPJfilial).
				setString("control", CNPJcontrol).
				setInteger("idStatus", ProposalStatusCD.PENDING.getId()).
				list();
		if(list.isEmpty()) return false;
		else return true;
	}
}