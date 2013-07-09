package br.com.dishup.core.exception;

public class RestaurantNotFoundException extends Throwable{

	private static final long serialVersionUID = -4779637842474967165L;

	public RestaurantNotFoundException(String message){
		super(message);
	}
}
