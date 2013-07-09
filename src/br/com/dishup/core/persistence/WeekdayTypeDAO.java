package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Session;
import br.com.dishup.core.entity.WeekdayTypeEntity;
import br.com.dishup.core.exception.EmptyTableException;

//TODO javadoc

public class WeekdayTypeDAO {

	public void insert(Session session, WeekdayTypeEntity weekday){
		session.save(weekday);
	}
	
	public void delete(Session session, int id){
		String hql = "DELETE FROM WeekdayTypeEntity WHERE id_tipo_dia_semana = :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	public List<WeekdayTypeEntity> selectAllOrderById(Session session) throws EmptyTableException{
		String hql = "FROM WeekdayTypeEntity ORDER BY id_tipo_dia_semana";
		@SuppressWarnings("unchecked")
		List<WeekdayTypeEntity> list = session.createQuery(hql).list();
		if(list.isEmpty())
			throw new EmptyTableException("NO RESULTS FOUND TO THIS QUERY");
		return list;
	}
}