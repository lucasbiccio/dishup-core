package br.com.dishup.core.exception;

/**
 * @author lucasbiccio
 * @since 17/05/2013
 * @version 1.0
 * Class responsible for encapsulate the cargo not found exception
 */
public class EmploymentNotFoundException extends Throwable{
	
	private static final long serialVersionUID = 1L;

	public EmploymentNotFoundException(String message) {
		super(message);
	}
}
