package br.com.dishup.core.exception;

public class ProposalNotFoundException extends Throwable {
	
	private static final long serialVersionUID = 5353834442680746L;

	public ProposalNotFoundException(String message){
		super(message);
	}
}
