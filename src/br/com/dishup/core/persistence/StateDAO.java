package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.dishup.core.entity.StateEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.StateNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 02/02/2013
 * @version 1.0 Class responsible for encapsulate the state data access object 
 */
public class StateDAO {

	/**
	 * Method responsible for insert an state object into database
	 * @param session database connection
	 * @param state to be insert
	 */
	public void insert(Session session, StateEntity state){
		session.save(state);
	}
	
	/**
	 * Method responsible for select an state by acronym
	 * @param session database connection
	 * @param acronym of state
	 * @return state object
	 * @throws StateNotFoundException 
	 */
	public StateEntity selectByAcronym(Session session, String acronym) throws StateNotFoundException{
		String hql = "FROM StateEntity estado WHERE sigla_estado = :acronym";
		StateEntity state = (StateEntity) session.createQuery(hql).setString("acronym", acronym).uniqueResult();
		if(state != null) return state;
		else throw new StateNotFoundException("STATE NOT FOUND - STATE ACRONYM: "+acronym);
	}
	
	/**
	 * Method responsible for select a specific state by id
	 * @param session database connection
	 * @param id state s id
	 * @return state object
	 * @throws StateNotFoundException 
	 */
	public StateEntity selectById(Session session , int id) throws StateNotFoundException{
		String hql = "FROM StateEntity estado WHERE id_estado = :id";
		StateEntity state = (StateEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(state != null) return state;
		else throw new StateNotFoundException("STATE NOT FOUND - STATE ID: "+id);
	}

	/**
	 * Method responsible for select all state ordered by id
	 * @param session database connection
	 * @return list of state
	 * @throws EmptyTableException throw when the database is empty
	 */
	public List<StateEntity> selectAllOrderById(Session session) throws EmptyTableException{
		Query query = session.createQuery("FROM StateEntity ORDER BY id_estado");
		@SuppressWarnings("unchecked")
		List<StateEntity> stateList = query.list();
		if(stateList.isEmpty())
			throw new EmptyTableException("NO RESULT FOUND TO THIS QUERY");
		return stateList;
	}
	
	/**
	 * Method responsible for delete a specific state by id
	 * @param session database connection
	 * @param id state s id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM StateEntity estado WHERE id_estado= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	/**
	 * Method responsible for select all states by an specific country
	 * @param session database connection
	 * @return states s list
	 * @throws EmptyTableException when there is no result found
	 */
	public List<StateEntity> selectByCountryId(Session session, int idCountry) throws EmptyTableException{
		Query query = session.createQuery("FROM StateEntity WHERE id_pais = :idCountry ORDER BY sigla_estado");
		@SuppressWarnings("unchecked")
		List<StateEntity> stateList = query.setInteger("idCountry", idCountry).list();
		if(stateList.isEmpty())
			throw new EmptyTableException("NO RESULT FOUND TO THIS QUERY");
		return stateList;
	}
}