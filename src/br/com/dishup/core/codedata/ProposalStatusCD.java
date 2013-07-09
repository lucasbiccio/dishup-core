package br.com.dishup.core.codedata;

/**
 * @author lucasbiccio
 * @since 17/05/2013
 * @version 1.0
 * Enum responsible to represent the proposta s status types
 */
public enum ProposalStatusCD {
	
	/**
	 * Status Proposta s constant
	 */
	PENDING (1,"Proposta Pendente"),
	APROOVED(2,"Proposta Aprovada"),
	REJECTED(3,"Proposta Rejeitada");
	
	/**
	 * Proposal Status s Attributes
	 */
	private final int id;
	private final String name;
	
	/**
	 * Method responsible for get the status s id
	 * @return status s id
	 *********************/
	public int getId() {
		return id;
	}
	
	/**
	 * Method responsible for get the status s name
	 * @return status s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Status s Constructor
	 * @param id - status s id
	 * @param nome - status s name
	 */
	private ProposalStatusCD(int id, String name) {
		this.id = id;
		this.name = name;
	}
}