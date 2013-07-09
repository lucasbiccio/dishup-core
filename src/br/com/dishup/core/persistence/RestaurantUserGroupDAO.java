package br.com.dishup.core.persistence;

import java.util.List;

import org.hibernate.Session;
import br.com.dishup.core.entity.RestaurantUserGroupEntity;
import br.com.dishup.core.exception.RestaurantUserGroupNotFoundException;

//TODO - Javadoc

public class RestaurantUserGroupDAO {

	public void insert(Session session, RestaurantUserGroupEntity group){
		session.save(group);
	}
	
	public void update(Session session, RestaurantUserGroupEntity group){
		session.update(group);
	}
	
	public List<RestaurantUserGroupEntity> selectByRestaurantId(Session session, int id) throws RestaurantUserGroupNotFoundException{
		String hql = "FROM RestaurantUserGroupEntity WHERE id_restaurante = :id";
		@SuppressWarnings("unchecked")
		List<RestaurantUserGroupEntity> listGroup = session.createQuery(hql).setInteger("id", id).list();
		if(listGroup.isEmpty()) throw new RestaurantUserGroupNotFoundException("GROUP NOT FOUND EXCEPTION - RESTAURANT ID: "+id);
		else return listGroup;
	}
}