package br.com.dishup.core.persistence;

import org.hibernate.Session;

import br.com.dishup.core.entity.RestaurantResponsibleEntity;
import br.com.dishup.core.exception.RestaurantResponsibleNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/07/2013
 * @version 1.0 Class responsible to encapsulate the data access restaurant responsible object
 */
public class RestaurantResponsibleDAO {

	/**
	 * Method responsible to insert a restaurant responsible object into database
	 * @param session database connection
	 * @param responsible s restaurant
	 */
	public void insert(Session session, RestaurantResponsibleEntity responsible){
		session.save(responsible);
	}
	
	/**
	 * Method responsible to update the object restaurant responsible into database
	 * @param session database connection
	 * @param responsible restaurant
	 */
	public void update(Session session, RestaurantResponsibleEntity responsible){
		session.update(responsible);
	}
	
	/**
	 * Method responsible to return a restaurant responsible object
	 * @param session database connection
	 * @param id restaurant
	 * @return restaurant responsible object
	 * @throws RestaurantResponsibleNotFoundException when there is no restaurant responsible object found
	 */
	public RestaurantResponsibleEntity selectByIdRestaurant(Session session, int id) throws RestaurantResponsibleNotFoundException{
		String hql = "FROM RestaurantResponsibleEntity WHERE id_restaurante = :id";
		RestaurantResponsibleEntity responsible = (RestaurantResponsibleEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(responsible == null) throw new RestaurantResponsibleNotFoundException("RESPONSIBLE NOT FOUND - ID RESTAURANT: "+id);
		else return responsible;
	}
}