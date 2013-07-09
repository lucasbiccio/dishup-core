package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Session;
import br.com.dishup.core.entity.ProposalStatusEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.StatusProposalNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 17/05/2013
 * @version 1.0
 * Class responsible to encapsulate the proposal s status data access logic.
 */
public class ProposalStatusDAO {
	
	/**
	 * Method responsible to save the proposta s status into database
	 * @param session database connection
	 * @param status proposta s status object
	 */
	public void insert(Session session, ProposalStatusEntity status){
		session.save(status);
	}
	
	/**
	 * Method responsible to delete a proposal s status from database by id
	 * @param session database connection
	 * @param id proposal s status id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM ProposalStatusEntity WHERE id_status_proposta = :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	/**
	 * Method responsible to select a proposal s status by it s id
	 * @param session database connection
	 * @param id proposal status id
	 * @return proposal s status object
	 * @throws StatusProposalNotFoundException thrown when status not found
	 */
	public ProposalStatusEntity selectById(Session session, int id) throws StatusProposalNotFoundException{
		String hql = "FROM ProposalStatusEntity WHERE id_status_proposta = :id";
		ProposalStatusEntity status = (ProposalStatusEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(status == null) throw new StatusProposalNotFoundException("PROPOSAL STATUS NOT FOUND - ID: "+id);
		else return status;
	}
	
	/**
	 * Method responsible to select all proposal s status ordered by id
	 * @param session database connection
	 * @return list of proposal s status ordered by id
	 * @throws EmptyTableException thrown when there is no register into database
	 */
	public List<ProposalStatusEntity> selectAllOrderById(Session session) throws EmptyTableException{
		String hql = "FROM ProposalStatusEntity ORDER BY id_status_proposta";
		@SuppressWarnings("unchecked")
		List<ProposalStatusEntity> list = session.createQuery(hql).list();
		if(list.isEmpty()) throw new EmptyTableException("PROPOSAL STATUS TABLE IS EMPTY");
		else return list;
	}
}