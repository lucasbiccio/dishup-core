package br.com.dishup.core.exception;

/**
 * @author lucasbiccio
 * @since 17/05/2013
 * @version 1.0
 * Class responsible for encapsulate the proposta s status not found exception.
 */
public class StatusProposalNotFoundException extends Throwable{
	
	private static final long serialVersionUID = 6002732653923833474L;

	public StatusProposalNotFoundException(String message){
		super(message);
	}

}
