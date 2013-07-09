package br.com.dishup.core.exception;

public class StatusRestaurantNotFoundException extends Throwable{
	
	private static final long serialVersionUID = -3981967643068744623L;

	public StatusRestaurantNotFoundException (String message) {
		super(message);
	}

}
