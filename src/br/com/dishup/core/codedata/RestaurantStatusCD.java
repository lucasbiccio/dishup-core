package br.com.dishup.core.codedata;

/**
 * @author lucasbiccio
 * @since 17/05/2013
 * @version 1.0
 * Enum responsible to represent the restaurante s status types
 */
public enum RestaurantStatusCD {
	
	/**
	 * Status Restaurante s constant
	 */
	ACTIVE (1,"Restaurante Ativo"),
	BLOCKED(2,"Restaurante Bloqueado");
	
	/**
	 * Status Restaurante s Attributes
	 */
	private final int id;
	private final String name;
	
	/**
	 * Method responsible for get the status s id
	 * @return Restaurante status s id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Method responsible for get the status s name
	 * @return status s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Status s Constructor
	 * @param id - status s id
	 * @param nome - status s name
	 */
	private RestaurantStatusCD(int id, String name) {
		this.id = id;
		this.name = name;
	}
}