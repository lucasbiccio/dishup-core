package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.dishup.core.entity.EmploymentEntity;
import br.com.dishup.core.exception.EmploymentNotFoundException;
import br.com.dishup.core.exception.EmptyTableException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 17/05/2013
 * @version 1.0
 * Class responsible for encapsulate the employment data access logic.
 */
public class EmploymentDAO {
	
	/**
	 * Method responsible to save the employment into database
	 * @param session database connection
	 * @param employment object
	 */
	public void insert(Session session, EmploymentEntity employment){
		session.save(employment);
	}
	
	/**
	 * Method responsible for select employment by it s id
	 * @param session database connection
	 * @param id employment s id
	 * @return employment object
	 * @throws EmploymentNotFoundException thrown when employment is not found
	 */
	public EmploymentEntity selectById(Session session, int id) throws EmploymentNotFoundException{
		String hql = "FROM EmploymentEntity WHERE id_cargo= :id";
		EmploymentEntity employment = (EmploymentEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(employment != null) return employment;
		else throw new EmploymentNotFoundException("EMPLOYMENT NOT FOUND - EMPLOYMENT ID: "+id);
	}
	
	/**
	 * Method responsible to delete a employment by it s id
	 * @param session database connection
	 * @param id employment s id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM EmploymentEntity WHERE id_cargo= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	/**
	 * Method responsible to select all employment ordered by id
	 * @param session database connection
	 * @return employment s list
	 * @throws EmploymentNotFoundException thrown when there is no employment into database
	 */
	public List<EmploymentEntity> selectAllOrderById(Session session) throws EmptyTableException{
		Query query = session.createQuery("FROM EmploymentEntity ORDER BY id_cargo");
		@SuppressWarnings("unchecked")
		List<EmploymentEntity> employmentList = query.list();
		if(employmentList.isEmpty())
			throw new EmptyTableException("NO EMPLOYMENT FOUND");
		return employmentList;
	}
}