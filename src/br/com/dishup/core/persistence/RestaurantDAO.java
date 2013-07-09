package br.com.dishup.core.persistence;

import org.hibernate.Session;
import br.com.dishup.core.entity.RestaurantEntity;
import br.com.dishup.core.exception.RestaurantNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 08/07/2013
 * @version 1.0 Class responsible to encapsulate the data access object restaurant
 */
public class RestaurantDAO {

	/**
	 * Method responsible to insert the restaurant object into database
	 * @param session connection database
	 * @param restaurant object
	 */
	public void insert(Session session, RestaurantEntity restaurant){
		session.save(restaurant);
	}
	
	/**
	 * Method responsible to update the restaurant object
	 * @param session database connection
	 * @param restaurant object
	 */
	public void update(Session session, RestaurantEntity restaurant){
		session.update(restaurant);
	}
	
	/**
	 * Method responsible to select a restaurant by it s id
	 * @param session connection database
	 * @param id restaurant
	 * @return restaurant object
	 * @throws RestaurantNotFoundException when there is no restaurant with informed id
	 */
	public RestaurantEntity selectById(Session session, int id) throws RestaurantNotFoundException{
		String hql = "FROM RestaurantEntity WHERE id_restaurante = :id";
		RestaurantEntity restaurant = (RestaurantEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(restaurant == null) throw new RestaurantNotFoundException("RESTAURANT NOT FOUND - ID: "+id);
		else return restaurant;
	}
	
	/**
	 * Method responsible get a specific restaurant by it s cnpj
	 * @param session database connection
	 * @param CNPJroot cnpj root
	 * @param CNPJfilial cnpj filial
	 * @param CNPJcontrol cnpj control
	 * @return a specific restaurant
	 * @throws RestaurantNotFoundException
	 */
	public RestaurantEntity selectByCNPJ(Session session, String CNPJroot, String CNPJfilial, String CNPJcontrol) throws RestaurantNotFoundException{
		String hql = "FROM RestaurantEntity WHERE CNPJ_numero = :root and CNPJ_filial = :filial and CNPJ_control = :controle";
		RestaurantEntity restaurant = (RestaurantEntity) session.createQuery(hql).
				setString("root", CNPJroot).
				setString("filial", CNPJfilial).
				setString("control", CNPJcontrol).
				uniqueResult();
		if(restaurant == null) throw new RestaurantNotFoundException("RESTAURANT NOT FOUND - CNPJ: "+CNPJroot+"/"+CNPJfilial+"/"+CNPJcontrol);
		else return restaurant;
	}
}