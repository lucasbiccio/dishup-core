package br.com.dishup.core.exception;

public class RestaurantScheduleNotFoundException extends Throwable {
	
	private static final long serialVersionUID = -4428064625368111519L;

	public RestaurantScheduleNotFoundException(String message){
		super(message);
	}

}
