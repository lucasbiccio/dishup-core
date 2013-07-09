package br.com.dishup.core.exception;

/*********************************
 * @author Lucas Biccio Ribeiro
 * @since 02/02/2013
 * @version 1.0 Class responsible for encapsulate the exception when an database table is empty
 *********************************/
public class EmptyTableException extends Throwable{
	
	private static final long serialVersionUID = 1L;

	/*****************
	 * Constructor
	 * @param message
	 ****************/
	public EmptyTableException(String message){
		super(message);
	}

}
