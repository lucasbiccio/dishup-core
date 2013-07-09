package br.com.dishup.core.exception;

public class UserRestaurantNotFoundException extends Throwable{
	
	private static final long serialVersionUID = 8880949359210998710L;

	public UserRestaurantNotFoundException(String message){
		super(message);
	}
}
