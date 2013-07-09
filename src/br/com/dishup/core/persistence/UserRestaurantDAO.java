package br.com.dishup.core.persistence;

import org.hibernate.Session;
import br.com.dishup.core.entity.UserRestaurantEntity;
import br.com.dishup.core.exception.UserRestaurantNotFoundException;

//TODO javadoc

public class UserRestaurantDAO {

	public void insert(Session session, UserRestaurantEntity user){
		session.save(user);
	}
	
	public void update(Session session, UserRestaurantEntity user){
		session.update(user);
	}
	
	public UserRestaurantEntity selectById(Session session, int id) throws UserRestaurantNotFoundException{
		String hql = "FROM UserRestaurantEntity WHERE id_usuario_restaurante = :id";
		UserRestaurantEntity user = (UserRestaurantEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(user == null) throw new UserRestaurantNotFoundException("USER RESTAURANT NOT FOUND EXCEPTION - ID: "+id);
		else return user;
	}
	
	public UserRestaurantEntity selectByEmail(Session session, String email) throws UserRestaurantNotFoundException{
		String hql = "FROM UserRestaurantEntity WHERE email_usuario_restaurante = :email";
		UserRestaurantEntity user = (UserRestaurantEntity) session.createQuery(hql).setString("email", email).uniqueResult();
		if(user == null) throw new UserRestaurantNotFoundException("USER RESTAURANT NOT FOUND EXCEPTION - EMAIL: "+email);
		else return user;
	}
}