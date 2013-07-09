package br.com.dishup.core.exception;

/**
 * @author lucasbiccio
 * @since 17/05/2013
 * @version 1.0
 * Class responsible to represent culinaria s tipo not found exception.
 */
public class CulinaryTypeNotFoundException extends Throwable {
	
	private static final long serialVersionUID = 9182302384629265548L;

	public CulinaryTypeNotFoundException(String message){
		super(message);
	}

}
