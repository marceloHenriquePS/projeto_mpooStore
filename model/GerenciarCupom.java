package model;

public class GerenciarCupom {
	
	private static double valorCupom(String codigo) {
		if (codigo.equals("MPOO50OFF")) {
			return 50.0;
		}
		
		if (codigo.equals(ValidadorCupomInterface.CUPOMPRIMEIRACOMPRA)) {
			return 25.0;
		}
		
		return 0;
	}
	
	public static boolean adicionarCupom(Cliente cliente, Cupom cupom) throws ClienteException, CupomException {
		if (cliente == null) {
			ClienteException clienteException = new ClienteException(null);
			throw new ClienteException(clienteException.CLIENTE_INVALID);
		}
		
		if (!cupom.validarCupom(cupom.codigo)) {
			throw new CupomException("Erro: Cupom Inválido");
		}
		
		if (!cliente.isCupomPrimeiroAcesso && cupom.codigo.equals(ValidadorCupomInterface.CUPOMPRIMEIRACOMPRA)) {
			throw new CupomException("Cupom já resgatado!");
		}
		
		if (cupom.codigo.equals(ValidadorCupomInterface.CUPOMPRIMEIRACOMPRA)) {
			cliente.isCupomPrimeiroAcesso = false;
		}	
		
		cupom.valor = valorCupom(cupom.codigo);
		cliente.cupom = cupom;
		return true;
	}
	
}
