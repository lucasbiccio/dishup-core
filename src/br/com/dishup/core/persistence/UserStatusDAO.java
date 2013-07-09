package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.dishup.core.entity.UserStatusEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.StatusUserNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 07/04/2013
 * @version 1.0 Class responsible for encapsulate the user s status data access operations.
 */
public class UserStatusDAO {
	
	/**
	 * Method responsible for insert a user s status into database
	 * @param session database connection
	 * @param status user s status
	 */
	public void insert(Session session, UserStatusEntity status){
		session.save(status);
	}
	
	/**
	 * Method responsible for delete a user s status by it s id
	 * @param session connection database
	 * @param id user s status id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM UserStatusEntity WHERE id_status_usuario = :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	/**
	 * Method responsible for select an user s status by id
	 * @param session database connecion
	 * @param id user s status id
	 * @return user s status
	 * @throws StatusUserNotFoundException 
	 */
	public UserStatusEntity selectById(Session session, int id) throws StatusUserNotFoundException{
		String hql = "FROM UserStatusEntity WHERE id_status_usuario = :id";
		UserStatusEntity status = (UserStatusEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(status != null) return status;
		else throw new StatusUserNotFoundException("STATUS USER NOT FOUND - USER STATUS ID: "+id);
	}
	
	/**
	 * Method responsible for select all user s status ordered by id
	 * @param session database connection
	 * @return list of all user s status
	 * @throws EmptyTableException when database is empty
	 */
	public List<UserStatusEntity> selectAllOrderById(Session session) throws EmptyTableException{
		Query query = session.createQuery("FROM UserStatusEntity ORDER BY id_status_usuario");
		@SuppressWarnings("unchecked")
		List<UserStatusEntity> statusUsuarioList = query.list();
		if(statusUsuarioList.isEmpty())
			throw new EmptyTableException("NO RESULTS FOUND TO THIS QUERY");
		return statusUsuarioList;
	}
}