package br.com.dishup.core.persistence;

import org.hibernate.Session;
import br.com.dishup.core.entity.RestaurantAddressEntity;
import br.com.dishup.core.exception.RestaurantAddressNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/03/2013
 * @version 1.0 Class responsible to encapsulate the restaurant address data access object
 */
public class RestaurantAddressDAO {

	/**
	 * Method responsible to insert a restaurant address into database
	 * @param session database connection
	 * @param restaurantAddress object
	 */
	public void insert(Session session, RestaurantAddressEntity restaurantAddress){
		session.save(restaurantAddress);
	}
	
	/**
	 * Method responsible to update the restaurant address object
	 * @param session database connection
	 * @param restaurantAddress object
	 */
	public void update(Session session, RestaurantAddressEntity restaurantAddress){
		session.update(restaurantAddress);
	}
	
	/**
	 * Method responsible to select a restaurant address object by restaurant id
	 * @param session database connection
	 * @param id restaurant s id
	 * @return restaurant address object
	 * @throws RestaurantAddressNotFoundException where a restaurant address is not found in database
	 */
	public RestaurantAddressEntity selectById(Session session, int id) throws RestaurantAddressNotFoundException{
		String hql = "FROM RestaurantAddressEntity endereco_restaurante WHERE id_restaurante = :id";
		RestaurantAddressEntity restaurantAddress = (RestaurantAddressEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(restaurantAddress == null) throw new RestaurantAddressNotFoundException("RESTAURANT ADDRESS NOT FOUND - ID: "+id);
		else return restaurantAddress;
	}
}