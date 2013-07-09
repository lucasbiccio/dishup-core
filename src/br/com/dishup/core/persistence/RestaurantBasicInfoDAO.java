package br.com.dishup.core.persistence;

import org.hibernate.Session;
import br.com.dishup.core.entity.RestaurantBasicInfoEntity;
import br.com.dishup.core.exception.RestaurantBasicInfoNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/07/2013
 * @version 1.0 Class responsible to encapsulate the restaurant basic info object.
 */
public class RestaurantBasicInfoDAO {
	
	/**
	 * Method responsible to insert the object restaurant basic info into database
	 * @param session database connection
	 * @param restaurantBasicInfo object
	 */
	public void insert(Session session, RestaurantBasicInfoEntity restaurantBasicInfo){
		session.save(restaurantBasicInfo);
	}
	
	/**
	 * Method responsible to update the object restaurant basic info into database
	 * @param session database connection
	 * @param restaurantBasicInfo object
	 */
	public void update(Session session, RestaurantBasicInfoEntity restaurantBasicInfo){
		session.update(restaurantBasicInfo);
	}
	
	/**
	 * Method responsible to select a restaurant basic info by restaurant s id
	 * @param session database connection
	 * @param id restaurant id
	 * @return restaurant basic info object
	 * @throws RestaurantBasicInfoNotFoundException when there is no data to restaurant id informed
	 */
	public RestaurantBasicInfoEntity selectById(Session session, int id) throws RestaurantBasicInfoNotFoundException{
		String hql = "FROM RestauranteBasicInfoEntity WHERE id_restaurante = :id";
		RestaurantBasicInfoEntity restaurantBasicInfo = (RestaurantBasicInfoEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(restaurantBasicInfo == null) throw new RestaurantBasicInfoNotFoundException("RESTAURANT BASIC INFO NOT FOUND - ID: "+id);
		else return restaurantBasicInfo;
	}
}
