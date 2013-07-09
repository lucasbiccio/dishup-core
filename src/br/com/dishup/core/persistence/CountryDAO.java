package br.com.dishup.core.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.dishup.core.entity.CountryEntity;
import br.com.dishup.core.exception.EmptyTableException;
import br.com.dishup.core.exception.CountryNotFoundException;

/**
 * @author Lucas Biccio Ribeiro
 * @since 02/02/2013
 * @version 1.0 Class responsible for encapsulate the country data access object 
 */
public class CountryDAO {

	/**
	 * Method responsible for insert a country into database
	 * @param session database connection
	 * @param country to be insert
	 */
	public void insert(Session session, CountryEntity country){
		session.save(country);
	}
	
	/**
	 * Method responsible for select a country by it s acronym
	 * @param session database connection
	 * @param acronym of country
	 * @return country object
	 * @throws CountryNotFoundException 
	 */
	public CountryEntity selectByAcronym(Session session, String acronym) throws CountryNotFoundException{
		String hql = "FROM CountryEntity pais WHERE sigla_pais= :acronym";
		CountryEntity country = (CountryEntity) session.createQuery(hql).setString("acronym", acronym).uniqueResult();
		if(country != null) return country;
		else throw new CountryNotFoundException("COUNTRY NOT FOUND - COUNTRY ACRONYM: "+acronym);
	}
	
	/**
	 * Method responsible for select a country by it s id
	 * @param session database connection
	 * @param id country
	 * @return country object
	 * @throws CountryNotFoundException 
	 */
	public CountryEntity selectById(Session session, int id) throws CountryNotFoundException{
		String hql = "FROM CountryEntity pais WHERE id_pais= :id";
		CountryEntity country = (CountryEntity) session.createQuery(hql).setInteger("id", id).uniqueResult();
		if(country != null) return country;
		else throw new CountryNotFoundException("COUNTRY NOT FOUND - COUNTRY ID: "+id);
	}
	
	/**
	 * Method responsible for select all country ordered by it s id
	 * @param session database connection
	 * @return a list of country
	 * @throws EmptyTableException when the database is empty
	 */
	public List<CountryEntity> selectAllOrderById(Session session) throws EmptyTableException{
		Query query = session.createQuery("FROM CountryEntity ORDER BY id_pais");
		@SuppressWarnings("unchecked")
		List<CountryEntity> countryList = query.list();
		if(countryList.isEmpty())
			throw new EmptyTableException("NO RESULT FOUND TO THIS QUERY");
		return countryList;
	}
	
	/**
	 * Method responsible for delete a country by it s id
	 * @param session database connection
	 * @param id country id
	 */
	public void deleteById(Session session, int id){
		String hql = "DELETE FROM CountryEntity pais WHERE id_pais= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
	}
}