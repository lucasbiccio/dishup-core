package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Session;
import br.com.dishup.core.entity.RestaurantScheduleEntity;
import br.com.dishup.core.exception.RestaurantScheduleNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/03/2013
 * @version 1.0 Class responsible to encapsulate the restaurant schedule object data access
 */
public class RestaurantScheduleDAO {

	/**
	 * Method responsible to insert a restaurant schedule into database
	 * @param session database connection
	 * @param schedule restaurant schedule object
	 */
	public void insert(Session session, RestaurantScheduleEntity schedule){
		session.save(schedule);
	}
	
	/**
	 * Method responsible to update the restaurant schedule
	 * @param session database connection
	 * @param schedule restaurant object
	 */
	public void update(Session session, RestaurantScheduleEntity schedule){
		session.update(schedule);
	}
	
	/**
	 * Method responsible to delete a restaurant schedule object from database
	 * @param session database connection
	 * @param schedule object
	 */
	public void delete(Session session, RestaurantScheduleEntity schedule){
		session.delete(schedule);
	}
	
	/**
	 * Method responsible to return a list of restaurant s schedules
	 * @param session database connection
	 * @param id restaurant
	 * @return list of restaurant s schedules
	 * @throws RestaurantScheduleNotFoundException when there is no schedule into database
	 */
	public List<RestaurantScheduleEntity> selectByRestaurantId(Session session, int id) throws RestaurantScheduleNotFoundException{
		String hql = "FROM RestaurantScheduleEntity WHERE id_restaurante = :id";
		@SuppressWarnings("unchecked")
		List<RestaurantScheduleEntity> schedules = session.createQuery(hql).setInteger("id", id).list();
		if(schedules.isEmpty()) throw new RestaurantScheduleNotFoundException("SCHEDULE NOT FOUND - RESTAURANT ID: "+id);
		else return schedules;
	}
}