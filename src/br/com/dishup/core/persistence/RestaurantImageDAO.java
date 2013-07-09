package br.com.dishup.core.persistence;

import java.util.List;

import org.hibernate.Session;

import br.com.dishup.core.entity.RestaurantImageEntity;
import br.com.dishup.core.exception.EmptyTableException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/03/2013
 * @version 1.0 Class responsible to encapsulate the data access object restaurant image
 */
public class RestaurantImageDAO {
	
	/**
	 * Method responsible to insert the object restaurant image into database
	 * @param session database connection
	 * @param image restaurant image
	 */
	public void insert(Session session, RestaurantImageEntity image){
		session.save(image);
	}
	
	/**
	 * Method responsible to update the restaurant image object
	 * @param session database connection
	 * @param image restaurant image
	 */
	public void update(Session session, RestaurantImageEntity image){
		session.update(image);
	}
	
	/**
	 * Method responsible to get a list of all images from a specific restaurant
	 * @param session database connection
	 * @param id restaurant
	 * @return list of restaurants images
	 * @throws EmptyTableException when there is no register found to this query
	 */
	public List<RestaurantImageEntity> selectAllOrderById(Session session, int id) throws EmptyTableException{
		String hql = "FROM RestaurantImageEntity WHERE id_restaurante = :id";
		@SuppressWarnings("unchecked")
		List<RestaurantImageEntity> list = session.createQuery(hql).setInteger("id", id).list();
		if(list.isEmpty()) throw new EmptyTableException("NO RESULTS FOUND TO THIS QUERY");
		else return list;
	}
}