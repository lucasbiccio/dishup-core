package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.dishup.core.entity.CityEntity;
import br.com.dishup.core.exception.CityNotFoundException;
import br.com.dishup.core.exception.EmptyTableException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 02/02/2013
 * @version 1.0 
 * Class responsible for encapsulate the city data access object 
 */
public class CityDAO {

	/**
	 * Method responsible for insert a city into database
	 * @param session database connection
	 * @param city object
	 */
	public void insert(Session session, CityEntity city){
		session.save(city);
	}
	
	/**
	 * Method responsible for select a city by a specific id
	 * @param session database connection
	 * @param id city s id
	 * @return city object
	 * @throws CityNotFoundException 
	 */
	public CityEntity selectById(Session session, int id) throws CityNotFoundException{
		String hql = "FROM CityEntity WHERE id_cidade= :id";
		CityEntity city = (CityEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(city != null) return city;
		else throw new CityNotFoundException("CITY NOT FOUND - CITY ID: "+id);
	}
	
	/**
	 * Method responsible for select all city from database ordering by id
	 * @param session database connection
	 * @return list of city
	 * @throws EmptyTableException throw when the table is empty
	 */
	public List<CityEntity> selectAllOrderById(Session session) throws EmptyTableException{
		Query query = session.createQuery("FROM CityEntity ORDER BY id_cidade");
		@SuppressWarnings("unchecked")
		List<CityEntity> cityList = query.list();
		if(cityList.isEmpty())
			throw new EmptyTableException("NO CITY FOUND");
		return cityList;
	}
	
	/**
	 * Method responsible for delete a specific city by id
	 * @param session database connection
	 * @param id city s id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM CityEntity WHERE id_cidade= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
	
	/**
	 * Method responsible for return a list of city by a specific state
	 * @param session database connection
	 * @param idState state id
	 * @return list of city
	 * @throws EmptyTableException when there is no register found
	 */
	public List<CityEntity> selectByStateId (Session session, int idState) throws EmptyTableException{
		Query query = session.createQuery("FROM CityEntity WHERE id_estado = :idState ORDER BY nm_cidade");
		@SuppressWarnings("unchecked")
		List<CityEntity> cityList = query.setInteger("idState", idState).list();
		if(cityList.isEmpty())
			throw new EmptyTableException("NO CITY FOUND");
		return cityList;
	}
}