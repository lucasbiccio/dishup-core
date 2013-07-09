package br.com.dishup.core.exception;

/*********************************
 * @author Lucas Biccio Ribeiro
 * @since 02/02/2013
 * @version 1.0 Class responsible for encapsulate the exception when an Pais does not exists in database
 *********************************/
public class CountryNotFoundException extends Throwable{
	
	private static final long serialVersionUID = 1L;

	/*****************
	 * Constructor
	 * @param message
	 ****************/
	public CountryNotFoundException(String message){
		super(message);
	}

}
