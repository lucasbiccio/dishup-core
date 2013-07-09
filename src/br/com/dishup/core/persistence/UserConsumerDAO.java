package br.com.dishup.core.persistence;

import org.hibernate.Session;
import br.com.dishup.core.entity.UserConsumerEntity;
import br.com.dishup.core.exception.UserConsumerNotFoundException;

//TODO javadoc

public class UserConsumerDAO {
	
	public void insert(Session session, UserConsumerEntity user){
		session.save(user);
	}
	
	public void update(Session session, UserConsumerEntity user){
		session.update(user);
	}
	
	public UserConsumerEntity selectById(Session session, int id) throws UserConsumerNotFoundException{
		String hql = "FROM UserConsumerEntity WHERE id_usuario_consumidor = :id";
		UserConsumerEntity user = (UserConsumerEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(user == null) throw new UserConsumerNotFoundException("USER CONSUMER NOT FOUND EXCEPTION - ID: "+id);
		else return user;
	}
	
	public UserConsumerEntity selectByEmail(Session session, String email) throws UserConsumerNotFoundException{
		String hql = "FROM UserConsumerEntity WHERE email_usuario_consumidor = :email";
		UserConsumerEntity user = (UserConsumerEntity) session.createQuery(hql).setString("email", email).uniqueResult();
		if(user == null) throw new UserConsumerNotFoundException("USER CONSUMER NOT FOUND EXCEPTION - EMAIL: "+email);
		else return user;
	}
}