package model;

public class Cliente {
	String email;
	Cupom cupom;
	boolean isCupomPrimeiroAcesso;
	
	public Cliente(String email) {
		this.email = email;
		isCupomPrimeiroAcesso = true;
	}
}
