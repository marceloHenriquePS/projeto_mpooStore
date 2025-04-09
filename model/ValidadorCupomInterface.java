package model;

public interface ValidadorCupomInterface {
	static final String CUPOMPRIMEIRACOMPRA = "PRIMEIRACOMPRAMPOO";
	
	public boolean validarCupom(String codigoCupom);
	
	public static boolean validarCupomPrimeiraCompra(String codigoCupom) {
		if (!codigoCupom.equals(CUPOMPRIMEIRACOMPRA)) {
			return false;
		}
		
		return true;
		
	}
	
}
