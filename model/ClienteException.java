package model;

@SuppressWarnings("serial")
public class ClienteException extends Exception{
	final String CLIENTE_NOEXIST_ERROR = "Cliente não existe.";
	final String CLIENTE_EXIST_ERROR = "Cliente já existe.";
	final String CLIENTE_INVALID = "Cliente inválido.";
	
	public ClienteException(String mensagem) {
		super(mensagem);
	}

	public String getCLIENTE_NOEXIST_ERROR() {
		return CLIENTE_NOEXIST_ERROR;
	}

	public String getCLIENTE_EXIST_ERROR() {
		return CLIENTE_EXIST_ERROR;
	}

	public String getCLIENTE_INVALID() {
		return CLIENTE_INVALID;
	}
	
	
}
