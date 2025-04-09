package model;

public class Cupom implements ValidadorCupomInterface {
	String codigo;
	double valor;
	
	public Cupom(String codigo) {	
		this.codigo = codigo;
	}

	@Override
	public boolean validarCupom(String codigoCupom) {
		if (codigoCupom == null || codigoCupom.isEmpty()) {
			return false;
		}
		
		if (ValidadorCupomInterface.validarCupomPrimeiraCompra(codigoCupom)) {
			return true;
		}
		
		if (codigoCupom.equals("MPOO50OFF")) {
			return true;
		}
		
		return false;
	}
}
