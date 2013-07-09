package br.com.dishup.core.exception;

public class UserConsumerNotFoundException extends Throwable{
	
	private static final long serialVersionUID = -3679799950302469554L;

	public UserConsumerNotFoundException(String message){
		super(message);
	}

}
