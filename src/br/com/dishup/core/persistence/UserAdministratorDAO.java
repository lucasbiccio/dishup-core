package br.com.dishup.core.persistence;

import org.hibernate.Session;
import br.com.dishup.core.entity.UserAdministratorEntity;
import br.com.dishup.core.exception.UserAdministratorNotFoundException;

//TODO - javadoc

public class UserAdministratorDAO {
	
	public void insert(Session session, UserAdministratorEntity administrator){
		session.save(administrator);
	}
	
	public void update(Session session, UserAdministratorEntity administrator){
		session.update(administrator);
	}
	
	public UserAdministratorEntity selectById(Session session, int id) throws UserAdministratorNotFoundException{
		String hql = "FROM UserAdministratorEntity WHERE id_usuario_administrador = :id";
		UserAdministratorEntity user = (UserAdministratorEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(user == null) throw new UserAdministratorNotFoundException("USER ADMINISTRATOR NOT FOUND EXCEPTION - ID: "+id);
		else return user;
	}
	
	public UserAdministratorEntity selectByEmail(Session session, String email) throws UserAdministratorNotFoundException{
		String hql = "FROM UserAdministratorEntity WHERE email_usuario_administrador = :email";
		UserAdministratorEntity user = (UserAdministratorEntity) session.createQuery(hql).setString("email", email).uniqueResult();
		if(user == null) throw new UserAdministratorNotFoundException("USER ADMINISTRATOR NOT FOUND EXCEPTION - EMAIL: "+email);
		else return user;
	}
}