package br.com.dishup.core.exception;

public class RestaurantAddressNotFoundException extends Throwable{
	
	private static final long serialVersionUID = -7633322138075473524L;

	public RestaurantAddressNotFoundException(String message){
		super(message);
	}

}
