package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Session;
import br.com.dishup.core.entity.RestaurantStatusEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.StatusRestaurantNotFoundException;

//TODO javadoc

public class RestaurantStatusDAO {
	
	public void insert(Session session, RestaurantStatusEntity status){
		session.save(status);
	}
	
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM RestaurantStatusEntity WHERE id_status_restaurante = :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	public RestaurantStatusEntity selectById(Session session, int id) throws StatusRestaurantNotFoundException{
		String hql = "FROM RestaurantStatusEntity WHERE id_status_restaurante = :id";
		RestaurantStatusEntity status = (RestaurantStatusEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(status == null) throw new StatusRestaurantNotFoundException("STATUS RESTAURANT NOT FOUND - ID: "+id);
		else return status;
	}
	
	public List<RestaurantStatusEntity> selectAllOrderById(Session session) throws EmptyTableException{
		String hql = "FROM RestaurantStatusEntity ORDER BY id_status_restaurante";
		@SuppressWarnings("unchecked")
		List<RestaurantStatusEntity> list = session.createQuery(hql).list();
		if(list.isEmpty()) throw new EmptyTableException("NO RESULTS FOUND TO THIS QUERY");
		else return list;
	}
}