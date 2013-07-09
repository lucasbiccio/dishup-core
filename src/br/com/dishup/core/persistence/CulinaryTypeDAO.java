package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Session;
import br.com.dishup.core.entity.CulinaryTypeEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.CulinaryTypeNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 17/05/2013
 * @version 1.0
 * Class responsible to encapsulate the culinary type data access object.
 */
public class CulinaryTypeDAO {

	/**
	 * Method responsible to save the culinary type into database
	 * @param session database connection
	 * @param culinaryType object
	 */
	public void insert(Session session, CulinaryTypeEntity culinaryType){
		session.save(culinaryType);
	}
	
	/**
	 * Method responsible to remove the culinary type from database
	 * @param session database connection
	 * @param id of culinary type
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM CulinaryTypeEntity WHERE id_tipo_culinaria = :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	/**
	 * Method responsible to select a culinary type from database
	 * @param session database connection
	 * @param id of culinary type
	 * @return culinary type object
	 * @throws CulinaryTypeNotFoundException thrown when culinary type is not found
	 */
	public CulinaryTypeEntity selectById(Session session, int id) throws CulinaryTypeNotFoundException{
		String hql = "FROM CulinaryTypeEntity WHERE id_tipo_culinaria = :id";
		CulinaryTypeEntity type = (CulinaryTypeEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(type == null) throw new CulinaryTypeNotFoundException("CULINARY TYPE NOT FOUND - ID: "+id);
		else return type;
	}
	
	/**
	 * Method responsible to select all culinary type from database ordered by id
	 * @param session database connection
	 * @return list of culinary type
	 * @throws EmptyTableException thrown when the table is empty
	 */
	public List<CulinaryTypeEntity> selectAllOrderById(Session session) throws EmptyTableException{
		String hql = "FROM CulinaryTypeEntity ORDER BY id_tipo_culinaria";
		@SuppressWarnings("unchecked")
		List<CulinaryTypeEntity> list = session.createQuery(hql).list();
		if (list.isEmpty()) throw new EmptyTableException("TABLE CULINARY TYPE IS EMPTY");
		else return list;
	}
}