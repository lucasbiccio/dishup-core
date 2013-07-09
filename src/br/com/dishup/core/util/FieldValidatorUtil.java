package br.com.dishup.core.util;

import java.util.regex.Pattern;

/**
 * @author Lucas Biccio Ribeiro
 * @since 17/05/2013
 * @version 1.0
 * Class responsible to validate fields.
 */
public class FieldValidatorUtil {
	
	/**
	 * Validate email method
	 * @param email an email
	 * @return true if it is valid or false it is not
	 */
	public static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
        return pattern.matcher(email).matches();
	}
 
	/**
	 * Method responsible to validate if a variable was filled up or not (if it is empty or blank) 
	 * @param var variable
	 * @return true if the variable is blank or empty or false if it is not
	 */
	public static boolean isEmpty(String var){
		Pattern pattern = Pattern.compile("\\s+");
		if(var == null) return true;
        if(pattern.matcher(var).matches() || var.isEmpty()) return true;
        else return false;
    }
	
	/**
	 * Method responsible to validate an password.
	 * The password must have 6 to 18 characters
	 * @param password password
	 * @return true if it is a valid password or false if it is not
	 */
	public static boolean isValidPassword(String password){
		Pattern pattern1 = Pattern.compile("\\w{6,18}");
		return (pattern1.matcher(password).matches());
	}
	
	/**
	 * Method responsible to validade a DDD number
	 * @param ddd DDD number
	 * @return true if it valid or false it is not
	 */
	public static boolean isValidDDD(String ddd){
		Pattern patternDDD = Pattern.compile("\\d{3}");
		return patternDDD.matcher(ddd).matches();
	}
	
	/**
	 * Method responsible to validate a telephone number
	 * @param telephone telephone number
	 * @return true if it is valid or false it is not
	 */
	public static boolean isValidTelephone(String telephone){
		Pattern patternTelefone = Pattern.compile("\\d{8,9}");
		return patternTelefone.matcher(telephone).matches();
	}
	
	/**
	 * Method responsible to validate a CEP
	 * @param CEP CEP number
	 * @return true if it is valid or false if it is not
	 */
	public static boolean isValidCEP(String CEP){
		Pattern patternCEP = Pattern.compile("\\d{8}");
		return patternCEP.matcher(CEP).matches();
	}
	
	/**
	 * Method responsible to validate an id field
	 * @param id id value
	 * @return true if it is valid or false if it is not
	 */
	public static boolean isValidId(int id){
		if(id > 0)return true;
		else return false;
	}
	
	/**
	 * Method responsible to validate a CNPJ
	 * @param numeroCNPJ CNPJ root
	 * @param filialCNPJ CNPJ filial
	 * @param controleCNPJ CNPJ control
	 * @return true if it is valid or false it is not
	 */
	public static boolean isValidCNPJ(String numeroCNPJ, String filialCNPJ, String controleCNPJ){
		Pattern patternNumeroCNPJ = Pattern.compile("\\d{8}");
		Pattern patternFilialCNPJ = Pattern.compile("\\d{4}");
		Pattern patternControleCNPJ = Pattern.compile("\\d{2}");
		if(!patternNumeroCNPJ.matcher(numeroCNPJ).matches()) return false;
		if(!patternFilialCNPJ.matcher(filialCNPJ).matches()) return false;
		if(!patternControleCNPJ.matcher(controleCNPJ).matches()) return false;
		String CNPJ = numeroCNPJ+filialCNPJ+controleCNPJ;
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
		    CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
		    CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
		    CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
		    CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999"))
			return false;
		String cnpjAux = numeroCNPJ.concat(filialCNPJ);
		int multiplicador = 5, soma = 0;
		for (int i = 0; i < cnpjAux.length(); i++) {
			soma = soma + (Integer.parseInt(cnpjAux.substring(i, i + 1)) * multiplicador);
			multiplicador--;
			if(multiplicador < 2) multiplicador = 9;
		}
		int dig1 = soma % 11;
		if(dig1 < 2) dig1 = 0;
		else dig1 = 11 - dig1;
		String digito1 = String.valueOf(dig1);
		if(!digito1.equals(controleCNPJ.substring(0, 1))) return false;
		soma = 0; multiplicador = 6;
		String cnpjAux2 = cnpjAux.concat(controleCNPJ.substring(0, 1));
		for (int i = 0; i < cnpjAux2.length(); i++) {
			soma = soma + (Integer.parseInt(cnpjAux2.substring(i, i + 1)) * multiplicador);
			multiplicador--;
			if(multiplicador < 2) multiplicador = 9;
		}
		int dig2 = soma % 11;
		if(dig2 < 2) dig2 = 0;
		else dig2 = 11 - dig2;
		String digito2 = String.valueOf(dig2);
		if(!digito2.equals(controleCNPJ.substring(1, 2))) return false;
		return true;
	}
	
	/**
	 * Method responsible to validate a CPF
	 * @param numeroCPF CPF root
	 * @param controleCPF CPF control
	 * @return true if it is valid or false it is not
	 */
	public static boolean isValidCPF(String numeroCPF, String controleCPF){
		Pattern patternNumeroCPF = Pattern.compile("\\d{9}");
		Pattern patternControleCPF = Pattern.compile("\\d{2}");
		if(!patternNumeroCPF.matcher(numeroCPF).matches()) return false;
		if(!patternControleCPF.matcher(controleCPF).matches()) return false;
		String CPF = numeroCPF+controleCPF;
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
		    CPF.equals("22222222222") || CPF.equals("33333333333") ||
		    CPF.equals("44444444444") || CPF.equals("55555555555") ||
		    CPF.equals("66666666666") || CPF.equals("77777777777") ||
		    CPF.equals("88888888888") || CPF.equals("99999999999"))
			return false;
		int soma = 0, multiplicador = 10;
		for (int i = 0; i < numeroCPF.length(); i++) {
			soma = soma + (Integer.parseInt(numeroCPF.substring(i, i + 1)) * multiplicador);
			multiplicador--;
		}
		int dig1 = soma % 11;
		if(dig1 < 2) dig1 = 0;
		else dig1 = 11 - dig1;
		String digito1 = String.valueOf(dig1);
		if(!digito1.equals(controleCPF.substring(0, 1))) return false;
		soma = 0; multiplicador = 11;
		String cpfAux = numeroCPF.concat(digito1);
		for (int i = 0; i < cpfAux.length(); i++) {
			soma = soma + (Integer.parseInt(cpfAux.substring(i, i + 1)) * multiplicador);
			multiplicador--;
		}
		int dig2 = soma % 11;
		if(dig2 < 2) dig2 = 0;
		else dig2 = 11 - dig2;
		String digito2 = String.valueOf(dig2);
		if(!digito2.equals(controleCPF.substring(1, 2))) return false;
		return true;
	}
}
