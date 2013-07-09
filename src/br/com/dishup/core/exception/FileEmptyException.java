package br.com.dishup.core.exception;

public class FileEmptyException extends Throwable{
	
	private static final long serialVersionUID = 3323893680260945950L;

	public FileEmptyException(String message){
		super(message);
	}
}
