package br.com.dishup.core.exception;

public class StatusUserNotFoundException extends Throwable{
	
	private static final long serialVersionUID = 1L;

	public StatusUserNotFoundException(String message){
		super(message);
	}

}
