package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.dishup.core.entity.UserTypeEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.UserTypeNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 07/04/2013
 * @version 1.0 Class responsible for encapsulate the user s type data access operation.
 * This class is a kind of a code data entity.
 */
public class UserTypeDAO {
	
	/**
	 * Method responsible for insert a user s type into database 
	 * @param session database connection
	 * @param userType user s type object
	 */
	public void insert(Session session, UserTypeEntity userType){
		session.save(userType);
	}
	
	/**
	 * Method responsible for select an user s type by it s id
	 * @param session connection database
	 * @param id user s type id
	 * @return user s type object
	 * @throws UserTypeNotFoundException 
	 */
	public UserTypeEntity selectById(Session session, int id) throws UserTypeNotFoundException{
		String hql = "FROM UserTypeEntity WHERE id_tipo_usuario = :id";
		UserTypeEntity type = (UserTypeEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(type != null) return type;
		else throw new UserTypeNotFoundException("USER TYPE NOT FOUND - USER TYPE ID: "+id);
	}
	
	/**
	 * Method responsible for select all user s type ordered by id
	 * @param session connection database
	 * @return list of all user s type object
	 * @throws EmptyTableException when table tipo_usuario is empty
	 */
	public List<UserTypeEntity> selectAllOrderById(Session session) throws EmptyTableException{
		Query query = session.createQuery("FROM UserTypeEntity ORDER BY id_tipo_usuario");
		@SuppressWarnings("unchecked")
		List<UserTypeEntity> list = query.list();
		if(list.isEmpty()) throw new EmptyTableException("USER TYPE TABLE IS EMPTY");
		return list;
	}
	
	/**
	 * Method responsible for delete an specific user s type by it s id
	 * @param session connection database
	 * @param id user s type id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM UserTypeEntity WHERE id_tipo_usuario = :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
}